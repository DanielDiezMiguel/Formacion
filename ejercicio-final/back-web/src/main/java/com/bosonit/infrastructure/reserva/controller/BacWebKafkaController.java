package com.bosonit.infrastructure.reserva.controller;

import com.bosonit.application.reserva.port.KafkaProducerPort;
import com.bosonit.domain.no_collection.KafkaItem;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaOutputDTO;
import com.bosonit.kafka.configuration.reservas.KafkaTopicConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v0/reserva/kafka")
public class BacWebKafkaController {

    @Autowired
    KafkaProducerPort kafkaProducerPort;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody KafkaItem kafkaItem) {
        kafkaProducerPort.sendMessage(kafkaItem);
        return ResponseEntity.ok("Message sent to the topic");
    }

}