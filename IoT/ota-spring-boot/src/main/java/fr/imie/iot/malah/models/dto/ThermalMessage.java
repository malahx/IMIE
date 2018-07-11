package fr.imie.iot.malah.models.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ThermalMessage {

    private Instant time;

    private String uuid;

    private Double temperature;

    private Double humidity;

}
