package fr.imie.iot.malah.models.dto;

import lombok.Data;

@Data
public class DeviceDTO {

    private String uuid;

    private int hwVer = 1;

    private int swVer = 1;

    private int uptime;

}
