package com.bosonit.infrastructure.reserva.controller;

import com.bosonit.application.reserva.port.KafkaProducerPort;
import com.bosonit.domain.no_collection.KafkaItemReservas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v0/reserva/kafka")
public class BackWebKafkaController {

    @Autowired
    KafkaProducerPort kafkaProducerPort;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody KafkaItemReservas kafkaItemReservas) {
        kafkaProducerPort.sendMessage(kafkaItemReservas);
        return ResponseEntity.ok("Message sent to the topic");
    }

}