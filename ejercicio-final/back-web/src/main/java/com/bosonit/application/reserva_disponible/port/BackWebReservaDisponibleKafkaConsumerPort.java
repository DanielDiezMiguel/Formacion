package com.bosonit.application.reserva_disponible.port;

import org.springframework.kafka.annotation.KafkaListener;

public interface BackWebReservaDisponibleKafkaConsumerPort {
    @KafkaListener(topics = "reservas-disponibles", groupId = "myGroup")
    void consumeMessage(String message);
}
