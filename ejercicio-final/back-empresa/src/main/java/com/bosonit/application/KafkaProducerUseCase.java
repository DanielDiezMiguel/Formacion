package com.bosonit.application;

import com.bosonit.application.reserva.port.KafkaProducerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerUseCase implements KafkaProducerPort {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send("reservas", message);
    }
}
