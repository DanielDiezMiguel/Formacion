package com.bosonit.application.port;

public interface KafkaProducerPort {
    void sendMessage(String message);
}
