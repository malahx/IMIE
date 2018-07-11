package fr.imie.iot.malah.models.mapper;

import fr.imie.iot.malah.models.dto.ThermalMessage;

public interface MessageMapper {

    ThermalMessage toThermalMessage(byte[] message);

    String toMessage(ThermalMessage thermalMessage);

}
