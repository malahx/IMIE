package fr.imie.iot.malah.rabbit;

import fr.imie.iot.malah.configurations.RabbitConfig;
import fr.imie.iot.malah.models.dto.ThermalMessage;
import fr.imie.iot.malah.models.mapper.MessageMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
@Component
public class DeviceConsumer {

    private static final String THERMAL = "thermal";

    private MessageMapper messageMapper;

    private InfluxDB influxDB;

    @RabbitListener(queues = RabbitConfig.QUEUE_SENSOR)
    public void receiveMessage(byte[] messageRaw) {

        log.info("DeviceConsumer({}): Receive message...", RabbitConfig.QUEUE_SENSOR);
        ThermalMessage thermalMessage = messageMapper.toThermalMessage(messageRaw);

        Point point = Point
                .measurement(THERMAL)
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("uuid", thermalMessage.getUuid())
                .addField("temperature", thermalMessage.getTemperature())
                .addField("humidity", thermalMessage.getHumidity())
                .build();
        influxDB.write(point);

        log.info("DeviceConsumer({}): Message received - {}.", RabbitConfig.QUEUE_SENSOR, thermalMessage);

    }
}
