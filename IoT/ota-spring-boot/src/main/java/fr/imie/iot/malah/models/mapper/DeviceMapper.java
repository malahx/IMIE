package fr.imie.iot.malah.models.mapper;

import fr.imie.iot.malah.models.dto.DeviceDTO;
import fr.imie.iot.malah.models.entities.Device;

public interface DeviceMapper {

    DeviceDTO toDTO(Device device);

    Device toDAO(DeviceDTO deviceDTO);

}
