package fr.imie.iot.malah.models.mapper.impl;

import fr.imie.iot.malah.models.dto.ThermalMessage;
import fr.imie.iot.malah.models.mapper.MessageMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Slf4j
@AllArgsConstructor
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public ThermalMessage toThermalMessage(byte[] rawMessage) {
        try {
            String[] splitMessage = new String(rawMessage, "UTF-8").split(";");
            return ThermalMessage.builder()
                    .time(Instant.parse(splitMessage[0]))
                    .uuid(splitMessage[1])
                    .temperature(Double.valueOf(splitMessage[2]))
                    .humidity(Double.valueOf(splitMessage[3]))
                    .build();
        } catch (Exception e) {
            log.error("Can't map", e);
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toMessage(ThermalMessage thermalMessage) {
        return String.format("%s;%s;%s;%s",
                thermalMessage.getTime().toString(),
                thermalMessage.getUuid(),
                thermalMessage.getTemperature(),
                thermalMessage.getHumidity());
    }
}
