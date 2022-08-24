package com.bosonit.application.port;

public interface KafkaProducerPort {

    void sendMessagge(String message);
}
