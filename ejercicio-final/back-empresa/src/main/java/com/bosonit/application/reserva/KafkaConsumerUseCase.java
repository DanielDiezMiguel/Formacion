package com.bosonit.application.reserva;

import com.bosonit.application.reserva.port.KafkaConsumerPort;
import com.bosonit.domain.no_collection.KafkaItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerUseCase implements KafkaConsumerPort {

    @Override
    @KafkaListener(topics = "reservas", groupId = "myGroup")
    public void consumeMessage(KafkaItem kafkaItem) {
        log.info("MESSAGE RECIEVED: {}", kafkaItem.toString());
    }
}
