package com.bosonit.kafka.configuration.reserva_disponible;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaBackEmpresaConfiguration {

    public NewTopic newTopic() {
        return TopicBuilder.name("reservas-disponibles").build();
    }
}
