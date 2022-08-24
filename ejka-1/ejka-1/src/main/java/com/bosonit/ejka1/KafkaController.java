package com.bosonit.ejka1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    KafkaMessageProducer kafkaMessageProducer;

    @PostMapping("/add/{topic}")
    public void addIdCustomer(@PathVariable(value = "topic") String topic, @RequestBody String body) {
        kafkaMessageProducer.sendMessage(topic, body);
    }
}