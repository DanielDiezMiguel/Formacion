package com.bosonit.application.reserva.port;

import com.bosonit.domain.no_collection.KafkaItemReservas;
import org.springframework.kafka.annotation.KafkaListener;

public interface KafkaBackEmpresaConsumerPort {
    @KafkaListener(topics = "reservas")
    void consumeMessage(KafkaItemReservas kafkaItemReservas);
}
