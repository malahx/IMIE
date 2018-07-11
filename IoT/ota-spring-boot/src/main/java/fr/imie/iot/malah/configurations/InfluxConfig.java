package fr.imie.iot.malah.configurations;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.impl.InfluxDBResultMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfluxConfig {

    @Value("${influxdb.db-name}")
    private String dbName;

    @Bean
    public InfluxDB influxDB() {
        InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086");
        influxDB.setDatabase(dbName);
        return influxDB;
    }

    @Bean
    public InfluxDBResultMapper influxDBResultMapper() {
        return new InfluxDBResultMapper();
    }

}
