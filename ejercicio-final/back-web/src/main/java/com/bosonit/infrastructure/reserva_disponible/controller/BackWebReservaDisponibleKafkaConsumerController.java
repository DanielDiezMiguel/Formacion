package com.bosonit.infrastructure.reserva_disponible.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/disponible/kafka/consumer")
public class BackWebReservaDisponibleKafkaConsumerController {

    @GetMapping
    @KafkaListener(topics = "reservas-disponibles", groupId = "myGroup")
    public ResponseEntity<String> recievedMessage(String message) {
        return ResponseEntity.ok(message);
    }
}
