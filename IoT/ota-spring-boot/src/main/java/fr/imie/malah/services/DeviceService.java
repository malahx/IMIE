package fr.imie.malah.services;

import fr.imie.malah.models.Device;
import fr.imie.malah.models.dto.DeviceDTO;
import fr.imie.malah.models.mapper.DeviceMapper;
import fr.imie.malah.repositories.DeviceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class DeviceService {

    private DeviceRepository repository;

    private DeviceMapper mapper;

    public DeviceDTO register(DeviceDTO device) {
        log.info("DeviceService(): Register...");
        Device deviceDao = repository.findByUuid(device.getUuid());
        if (deviceDao != null) {
            log.info("DeviceService({}): Already registered", deviceDao.getUuid());
        } else {
            deviceDao = repository.save(mapper.toDAO(device));
            log.info("DeviceService({}): Registered", deviceDao.getUuid());
        }
        return mapper.toDTO(deviceDao);
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
}
