package com.bosonit.infrastructure.reserva_disponible.controller;

import com.bosonit.application.reserva_disponible.port.KafkaBackEmpresaProducerPort;
import com.bosonit.domain.no_collection.KafkaItemReservas;
import com.bosonit.domain.no_collection.KafkaItemReservasDisponibles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/disponible/kafka/producer")
public class BackEmpresaKafkaReservaDisponibleController {

    @Autowired
    KafkaBackEmpresaProducerPort kafkaBackEmpresaProducerPort;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody KafkaItemReservasDisponibles kafkaItemReservasDisponibles) {
        kafkaBackEmpresaProducerPort.sendMessage(kafkaItemReservasDisponibles);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
