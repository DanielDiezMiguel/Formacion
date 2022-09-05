package com.bosonit.application.reserva.port;

import com.bosonit.domain.no_collection.KafkaItemReservas;

public interface KafkaProducerPort {

    void sendMessage(KafkaItemReservas kafkaItemReservas);
}
