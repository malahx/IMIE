package fr.imie.iot.malah.configurations;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitConfig {

    public static final String TOPIC_SENSOR = "/sensor";
    public static final String QUEUE_SENSOR = "/sensorQueue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_SENSOR, true);
    }

    @Bean
    public Exchange exchange() {
        return new TopicExchange(TOPIC_SENSOR);
    }

    @Bean
    public Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("sensor :")
                .noargs();
    }

}
