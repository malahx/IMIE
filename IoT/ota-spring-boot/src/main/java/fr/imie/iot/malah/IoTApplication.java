package fr.imie.iot.malah;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class IoTApplication {
    public static void main(String[] args) {
        log.debug("Start main Application...");
        SpringApplication.run(IoTApplication.class);
        log.debug("Main Application Started.");
    }
}
