package fr.imie.iot.malah.models.mapper;

import fr.imie.iot.malah.models.timeseries.Thermal;
import lombok.AllArgsConstructor;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class InfluxMapper {

    private InfluxDBResultMapper influxDBResultMapper;

    public List<Thermal> toThermal(QueryResult query) {
        return influxDBResultMapper.toPOJO(query, Thermal.class);
    }
}
