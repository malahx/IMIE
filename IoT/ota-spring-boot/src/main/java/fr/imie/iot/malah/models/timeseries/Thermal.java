package fr.imie.iot.malah.models.timeseries;

import lombok.Data;
import lombok.experimental.Accessors;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.time.Instant;

@Data
@Accessors(fluent = false)
@Measurement(name = "thermal")
public class Thermal {

    @Column(name = "time")
    private Instant time;

    @Column(name = "uuid", tag = true)
    private String uuid;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "humidity")
    private Double humidity;

}
