package com.bosonit.application.reserva_disponible;

import com.bosonit.application.reserva_disponible.port.KafkaBackEmpresaProducerPort;
import com.bosonit.domain.no_collection.KafkaItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaBackEmpresaBackEmpresaProducerUseCase implements KafkaBackEmpresaProducerPort {

    @Autowired
    KafkaTemplate<String, KafkaItem> kafkaTemplate;

    @Override
    public void sendMessage(KafkaItem kafkaItem) {
        Message<KafkaItem> message = MessageBuilder
                .withPayload(kafkaItem)
                .setHeader(KafkaHeaders.TOPIC, "reservas-disponibles")
                .build();
        kafkaTemplate.send(message);

        //TODO: Crear clase en back-web y back-empresa para poder producir y consumir ciudades disponibles
    }
}
