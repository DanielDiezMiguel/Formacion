package com.bosonit.ejka1;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumer {

    @KafkaListener(topics = "${message.topic.name}", groupId = "${message.group.name}")
    public void listenerTopic(String message) {
        System.out.println("RECEIVED MESSAGE: " + message);
    }
}
