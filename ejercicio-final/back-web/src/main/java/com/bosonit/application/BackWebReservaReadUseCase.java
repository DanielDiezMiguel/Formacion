package com.bosonit.application;

import com.bosonit.application.port.BackWebReservaReadPort;
import com.bosonit.domain.BackWebReservaEntity;
import com.bosonit.infrastructure.controller.dto.BackWebReservaOutputDTO;
import com.bosonit.infrastructure.repository.mongodb.MongoDBRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BackWebReservaReadUseCase implements BackWebReservaReadPort {

    @Autowired
    MongoDBRepository mongoDBRepository;

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public ResponseEntity<List<BackWebReservaOutputDTO>> getAllReservas(String ciudad, Date fecha, String condicion) {
        List<BackWebReservaOutputDTO> backWebReservaOutputDTOList = new ArrayList<>();

        if (condicion != null) {
            switch (condicion) {
                case "inferior":
                    Query inferior = new Query(new Criteria()
                            .orOperator(
                                    Criteria.where("ciudad").is(ciudad),
                                    Criteria.where("fechaMs").lt(fecha.getTime())
                            ));
                    mongoTemplate.find(inferior, BackWebReservaEntity.class, "reservas")
                            .forEach(backWebReservaEntity -> backWebReservaOutputDTOList
                                    .add(new BackWebReservaOutputDTO(backWebReservaEntity)));
                    break;

                case "superior":
                    Query superior = new Query(new Criteria()
                            .orOperator(
                                    Criteria.where("ciudad").is(ciudad),
                                    Criteria.where("fecha").gt(fecha)
                            ));
                    mongoTemplate.find(superior, BackWebReservaEntity.class, "reservas")
                            .forEach(backWebReservaEntity -> backWebReservaOutputDTOList
                                    .add(new BackWebReservaOutputDTO(backWebReservaEntity)));
                    break;
            }

        } else {
            Query query = new Query(Criteria.where("ciudad").is(ciudad));
            mongoTemplate.find(query, BackWebReservaEntity.class, "reservas")
                    .forEach(backWebReservaEntity -> backWebReservaOutputDTOList
                            .add(new BackWebReservaOutputDTO(backWebReservaEntity)));
        }
        return ResponseEntity.ok(backWebReservaOutputDTOList);
    }
}
