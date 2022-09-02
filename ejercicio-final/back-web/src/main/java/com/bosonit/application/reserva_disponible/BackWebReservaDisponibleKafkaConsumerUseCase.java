package com.bosonit.application.reserva_disponible;

import com.bosonit.application.reserva_disponible.port.BackWebReservaDisponibleKafkaConsumerPort;
import com.bosonit.domain.no_collection.KafkaItemReservasDisponibles;
import com.bosonit.domain.reserva_disponible.BackWebReservaDisponibleCollection;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleOutputDTO;
import com.bosonit.infrastructure.reserva_disponible.repository.mongodb.MongoDBRepositoryDisponible;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BackWebReservaDisponibleKafkaConsumerUseCase implements BackWebReservaDisponibleKafkaConsumerPort {

    @Autowired
    MongoDBRepositoryDisponible mongoDBRepositoryDisponible;

    @Autowired
    MongoTemplate mongoTemplate;

    //    @Override
//    @KafkaListener(topics = "reservas-disponibles", groupId = "myGroup")
//    public void consumeMessage(KafkaItemReservasDisponibles kafkaItemReservasDisponibles) {
//        log.info("MESSAGE RECIEVED: {}", kafkaItemReservasDisponibles.toString());
//    }
    @Override
    @KafkaListener(topics = "reservas-disponibles", groupId = "myGroup")
    public BackWebReservaDisponibleOutputDTO consumeMessageUpdate(
            KafkaItemReservasDisponibles kafkaItemReservasDisponibles) {

        log.info("MESSAGE RECIEVED: {}", kafkaItemReservasDisponibles.toString());

        if (mongoTemplate.count(Query.query(Criteria.where("ciudad").is(kafkaItemReservasDisponibles.getCiudad())),
                BackWebReservaDisponibleCollection.class, "reservas-disponibles") >= 1) {

            BackWebReservaDisponibleCollection backWebReservaDisponibleCollection =
                    new BackWebReservaDisponibleCollection();

            backWebReservaDisponibleCollection.update(kafkaItemReservasDisponibles);

            return new BackWebReservaDisponibleOutputDTO(mongoDBRepositoryDisponible
                    .save(backWebReservaDisponibleCollection));

        } else return new BackWebReservaDisponibleOutputDTO(mongoDBRepositoryDisponible
                .save(new BackWebReservaDisponibleCollection(kafkaItemReservasDisponibles)));
    }
}
