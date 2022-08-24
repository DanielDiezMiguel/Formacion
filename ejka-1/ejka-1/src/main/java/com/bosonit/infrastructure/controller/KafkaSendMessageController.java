package com.bosonit.infrastructure.controller;

import com.bosonit.application.port.KafkaProducerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaSendMessageController {

    @Autowired
    KafkaProducerPort kafkaProducerPort;

    @GetMapping("/publish")
    public ResponseEntity<String> publishMessageApp(@RequestParam("message") String message) {
        kafkaProducerPort.sendMessagge(message);
        return ResponseEntity.ok("MESSAGE SENT TO THE TOPIC");
    }
}