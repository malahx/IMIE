package fr.imie.malah.models.mapper;

import fr.imie.malah.models.Device;
import fr.imie.malah.models.dto.DeviceDTO;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DeviceMapper {

    private ModelMapper modelMapper;

    public DeviceDTO toDTO(Device device) {
        return modelMapper.map(device, DeviceDTO.class);
    }

    public Device toDAO(DeviceDTO deviceDTO) {
        return modelMapper.map(deviceDTO, Device.class);
    }

}
