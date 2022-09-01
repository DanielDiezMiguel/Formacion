package com.bosonit.application.reserva_disponible.port;

import com.bosonit.domain.no_collection.KafkaItem;

public interface KafkaBackEmpresaProducerPort {
    void sendMessage(KafkaItem kafkaItem);
}
