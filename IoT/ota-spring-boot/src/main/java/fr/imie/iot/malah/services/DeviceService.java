package fr.imie.iot.malah.services;

import fr.imie.iot.malah.models.dto.DeviceDTO;
import fr.imie.iot.malah.models.entities.Device;
import fr.imie.iot.malah.models.mapper.DeviceMapper;
import fr.imie.iot.malah.models.mapper.InfluxMapper;
import fr.imie.iot.malah.models.timeseries.Thermal;
import fr.imie.iot.malah.repositories.DeviceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.stereotype.Service;

import java.util.List;

import static fr.imie.iot.malah.utils.SQLRequest.THERMAL_FROM_SENSOR;

@Slf4j
@AllArgsConstructor
@Service
public class DeviceService {

    private DeviceRepository repository;

    private DeviceMapper deviceMapper;

    private InfluxDB influxDB;

    private InfluxMapper influxMapper;

    public DeviceDTO register(DeviceDTO device) {
        log.info("DeviceService(): Register...");
        Device deviceDao = repository.findByUuid(device.getUuid());
        if (deviceDao != null) {
            log.info("DeviceService({}): Already registered", deviceDao.getUuid());
        } else {
            deviceDao = repository.save(deviceMapper.toDAO(device));
            log.info("DeviceService({}): Registered", deviceDao.getUuid());
        }
        return deviceMapper.toDTO(deviceDao);
    }

    public boolean unregister(String uuid) {
        log.info("DeviceService({}): Unregister...", uuid);
        Device deviceDao = repository.findByUuid(uuid);
        if (deviceDao == null) {
            log.info("DeviceService({}): Not registered", uuid);
            return false;
        }
        repository.delete(deviceDao);
        log.info("DeviceService({}): Unregistered", deviceDao.getUuid());
        return true;
    }

    public List<Thermal> getData(String uuid) {
        log.info("DeviceService({}): Get Data...", uuid);
        QueryResult thermal = influxDB.query(new Query(String.format(THERMAL_FROM_SENSOR, uuid), "iot"));
        log.info("DeviceService({}): Data gotten.", uuid);
        return influxMapper.toThermal(thermal);
    }
}
