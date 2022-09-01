package com.bosonit.application.reserva;

import com.bosonit.application.reserva.port.KafkaConsumerPort;
import com.bosonit.domain.no_collection.KafkaItem;
import com.bosonit.domain.reserva.BackEmpresaReservaCollection;
import com.bosonit.infrastructure.reserva.repository.mongodb.MongoDBRepositoryEmpresa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerUseCase implements KafkaConsumerPort {

    @Autowired
    MongoDBRepositoryEmpresa mongoDBRepositoryEmpresa;

    @Override
    @KafkaListener(topics = "reservas", groupId = "myGroup")
    public void consumeMessage(KafkaItem kafkaItem) {
        mongoDBRepositoryEmpresa.save(new BackEmpresaReservaCollection(kafkaItem));
        log.info("MESSAGE RECIEVED: {}", kafkaItem.toString());
    }
}
