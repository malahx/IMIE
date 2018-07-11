package fr.imie.iot.malah.controllers;

import fr.imie.iot.malah.models.dto.DeviceDTO;
import fr.imie.iot.malah.models.timeseries.Thermal;
import fr.imie.iot.malah.services.DeviceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RequestMapping(path = Data.ROOT + Data.DEVICE)
@RestController
public class DeviceController {

    private DeviceService deviceService;

    @PostMapping
    public DeviceDTO register(@RequestBody DeviceDTO device) {
        log.info("DeviceController(): Register...");
        device = deviceService.register(device);
        log.info("DeviceController(): Registered");
        return device;
    }

    @DeleteMapping(path = Data.BY_UUID)
    public ResponseEntity unregister(@PathVariable String uuid) {
        log.info("DeviceController({}): Unregister...", uuid);
        boolean unregister = deviceService.unregister(uuid);
        if (unregister) {
            log.info("DeviceController({}): Unregistered.", uuid);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        log.info("DeviceController({}): Unregister failed.", uuid);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = Data.BY_UUID + Data.DATA)
    public ResponseEntity<List<Thermal>> getData(@PathVariable String uuid) {
        log.info("DeviceController({}): Get data...", uuid);
        List<Thermal> data = deviceService.getData(uuid);
        log.info("DeviceController({}): Data gotten.", uuid);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
