package com.bosonit.application.reserva.port;

import com.bosonit.domain.no_collection.KafkaItemReservas;

public interface KafkaProducerPort {
//    void sendMessage(BackWebReservaOutputDTO message);

    void sendMessage(KafkaItemReservas kafkaItemReservas);
}
