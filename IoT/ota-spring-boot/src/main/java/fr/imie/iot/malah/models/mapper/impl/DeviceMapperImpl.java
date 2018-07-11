package fr.imie.iot.malah.models.mapper.impl;

import fr.imie.iot.malah.models.entities.Device;
import fr.imie.iot.malah.models.dto.DeviceDTO;
import fr.imie.iot.malah.models.mapper.DeviceMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DeviceMapperImpl implements DeviceMapper {

    private ModelMapper modelMapper;

    public DeviceDTO toDTO(Device device) {
        return modelMapper.map(device, DeviceDTO.class);
    }

    public Device toDAO(DeviceDTO deviceDTO) {
        return modelMapper.map(deviceDTO, Device.class);
    }

}
