package com.bosonit.application.reserva_disponible;

import com.bosonit.application.reserva_disponible.port.KafkaBackEmpresaProducerPort;
import com.bosonit.domain.no_collection.KafkaItemReservas;
import com.bosonit.domain.no_collection.KafkaItemReservasDisponibles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaBackEmpresaBackEmpresaProducerUseCase implements KafkaBackEmpresaProducerPort {

    @Autowired
    KafkaTemplate<String, KafkaItemReservas> kafkaTemplate;

    @Override
    public void sendMessage(KafkaItemReservasDisponibles kafkaItemReservasDisponibles) {
        Message<KafkaItemReservasDisponibles> message = MessageBuilder
                .withPayload(kafkaItemReservasDisponibles)
                .setHeader(KafkaHeaders.TOPIC, "reservas-disponibles")
                .build();
        kafkaTemplate.send(message);

        //TODO: Comprobacion en BACK-WEB BBDD si coinciden las ciudades disponibles
    }
}
