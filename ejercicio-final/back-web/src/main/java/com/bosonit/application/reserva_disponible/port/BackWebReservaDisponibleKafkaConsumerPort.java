package com.bosonit.application.reserva_disponible.port;

import com.bosonit.domain.no_collection.KafkaItemReservasDisponibles;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleOutputDTO;
import org.springframework.kafka.annotation.KafkaListener;

public interface BackWebReservaDisponibleKafkaConsumerPort {

//    @KafkaListener(topics = "reservas-disponibles", groupId = "myGroup")
//    void consumeMessage(KafkaItemReservasDisponibles kafkaItemReservasDisponibles);

    @KafkaListener(topics = "reservas-disponibles", groupId = "myGroup")
    BackWebReservaDisponibleOutputDTO consumeMessageUpdate(KafkaItemReservasDisponibles kafkaItemReservasDisponibles);
}
