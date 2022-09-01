package com.bosonit.application.reserva_disponible.port;

public interface KafkaBackEmpresaProducerPort {
    void sendMessage(String message);
}
