package com.bosonit.application.reserva;

import com.bosonit.application.reserva.port.KafkaProducerPort;
import com.bosonit.domain.no_collection.KafkaItemReservas;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaProducerUseCase implements KafkaProducerPort {

    private KafkaTemplate<String, KafkaItemReservas> kafkaTemplate;

    @Override
    public void sendMessage(KafkaItemReservas kafkaItemReservas) {
        Message<KafkaItemReservas> message = MessageBuilder
                .withPayload(kafkaItemReservas)
                .setHeader(KafkaHeaders.TOPIC, "reservas")
                .build();
        kafkaTemplate.send(message);
    }

}
