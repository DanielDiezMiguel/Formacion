package com.bosonit.application.reserva_disponible;

import com.bosonit.application.reserva_disponible.port.BackWebReservaDisponibleKafkaConsumerPort;
import com.bosonit.domain.no_collection.KafkaItemReservasDisponibles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BackWebReservaDisponibleKafkaConsumerUseCase implements BackWebReservaDisponibleKafkaConsumerPort {

    @Override
    @KafkaListener(topics = "reservas-disponibles", groupId = "myGroup")
    public void consumeMessage(KafkaItemReservasDisponibles kafkaItemReservasDisponibles) {
        log.info("MESSAGE RECIEVED: {}", kafkaItemReservasDisponibles.toString());
    }
}
