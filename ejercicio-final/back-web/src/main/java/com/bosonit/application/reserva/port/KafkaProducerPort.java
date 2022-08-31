package com.bosonit.application.reserva.port;

import com.bosonit.domain.no_collection.KafkaItem;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaOutputDTO;

public interface KafkaProducerPort {
//    void sendMessage(BackWebReservaOutputDTO message);

    void sendMessage(KafkaItem kafkaItem);
}
