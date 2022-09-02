package com.bosonit.infrastructure.reserva_disponible.controller;

import com.bosonit.application.reserva_disponible.port.BackWebReservaDisponibleKafkaConsumerPort;
import com.bosonit.domain.no_collection.KafkaItemReservasDisponibles;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/disponible/kafka/consumer")
public class KafkaConsumerBackWebReservaDisponibleController {

    @Autowired
    BackWebReservaDisponibleKafkaConsumerPort backWebReservaDisponibleKafkaConsumerPort;

    @GetMapping
    public BackWebReservaDisponibleOutputDTO backWebReservaDisponibleOutputDTO(
            KafkaItemReservasDisponibles kafkaItemReservasDisponibles) {
        return backWebReservaDisponibleKafkaConsumerPort.consumeMessageUpdate(kafkaItemReservasDisponibles);
    }
}
