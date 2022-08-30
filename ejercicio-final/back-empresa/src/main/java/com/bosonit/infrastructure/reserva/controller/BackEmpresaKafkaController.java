package com.bosonit.infrastructure.reserva.controller;

import com.bosonit.application.reserva.port.KafkaProducerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v0/kafka/reserva")
public class BackEmpresaKafkaController {

    @Autowired
    KafkaProducerPort kafkaProducerPort;

    @GetMapping
    public ResponseEntity<String> sendMessage(@RequestParam(value = "message") String message) {
        kafkaProducerPort.sendMessage(message);
        return ResponseEntity.ok("MESSAGE SENT TO THE TOPIC");
    }
}