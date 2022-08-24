package com.bosonit.application;

import com.bosonit.application.port.KafkaProducerPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Profile("App2")
@AllArgsConstructor
@Slf4j
public class KafkaProducerApp2UseCase implements KafkaProducerPort {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessagge(String message) {
        log.info("MESSAGE SENT: {}", message);
        kafkaTemplate.send("ejka1Topic", message);
    }
}