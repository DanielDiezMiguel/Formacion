package com.bosonit.application.reserva;

import com.bosonit.application.reserva.port.KafkaBackEmpresaConsumerPort;
import com.bosonit.domain.no_collection.KafkaItemReservas;
import com.bosonit.domain.reserva.BackEmpresaReservaCollection;
import com.bosonit.infrastructure.reserva.repository.mongodb.MongoDBRepositoryEmpresa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaBackEmpresaBackEmpresaConsumerUseCase implements KafkaBackEmpresaConsumerPort {

    @Autowired
    MongoDBRepositoryEmpresa mongoDBRepositoryEmpresa;

    @Override
    @KafkaListener(topics = "reservas", groupId = "myGroup")
    public void consumeMessage(KafkaItemReservas kafkaItemReservas) {
        mongoDBRepositoryEmpresa.save(new BackEmpresaReservaCollection(kafkaItemReservas));
        log.info("MESSAGE RECIEVED: {}", kafkaItemReservas.toString());
    }
}
