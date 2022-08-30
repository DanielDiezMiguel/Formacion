package com.bosonit.application.reserva.port;

public interface KafkaProducerPort {
    void sendMessage(String message);
}
