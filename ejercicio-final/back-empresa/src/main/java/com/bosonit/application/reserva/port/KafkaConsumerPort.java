package com.bosonit.application.reserva.port;

import com.bosonit.domain.no_collection.KafkaItem;
import org.springframework.kafka.annotation.KafkaListener;

public interface KafkaConsumerPort {
    @KafkaListener(topics = "reservas")
    void consumeMessage(KafkaItem kafkaItem);
}
