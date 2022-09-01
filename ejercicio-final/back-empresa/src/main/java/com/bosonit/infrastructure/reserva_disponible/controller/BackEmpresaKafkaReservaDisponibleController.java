package com.bosonit.infrastructure.reserva_disponible.controller;

import com.bosonit.application.reserva_disponible.port.KafkaBackEmpresaProducerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/disponible/kafka/producer")
public class BackEmpresaKafkaReservaDisponibleController {

    @Autowired
    KafkaBackEmpresaProducerPort kafkaBackEmpresaProducerPort;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestParam(value = "message") String message) {
        kafkaBackEmpresaProducerPort.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
