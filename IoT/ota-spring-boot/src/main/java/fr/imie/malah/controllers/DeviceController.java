package fr.imie.malah.controllers;

import fr.imie.malah.models.dto.DeviceDTO;
import fr.imie.malah.services.DeviceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static fr.imie.malah.controllers.Data.DEVICE;
import static fr.imie.malah.controllers.Data.ROOT;

@Slf4j
@AllArgsConstructor
@RequestMapping(path = ROOT)
@RestController
public class DeviceController {

    private DeviceService deviceService;

    @PostMapping(path = DEVICE)
    public DeviceDTO register(@RequestBody DeviceDTO device) {
        log.info("DeviceController(): Register...");
        device = deviceService.register(device);
        log.info("DeviceController(): Registered");
        return device;
    }



    @DeleteMapping(path = DEVICE)
    public void unregister(@PathVariable String uuid) {
        log.info("DeviceController(): Unregister...");
        deviceService.unregister(uuid);
        log.info("DeviceController(): Unregistered");
    }

}
