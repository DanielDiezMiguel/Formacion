package com.bosonit.application;

import com.bosonit.application.port.BackWebReservaReadPort;
import com.bosonit.domain.BackWebReservaEntity;
import com.bosonit.infrastructure.controller.dto.BackWebReservaOutputDTO;
import com.bosonit.infrastructure.repository.mongodb.MongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<BackWebReservaOutputDTO>> getAllReservas(String ciudad, Date fechaHora, Date fechaHoraSuperior) {
        List<BackWebReservaOutputDTO> backWebReservaOutputDTOList = new ArrayList<>();

        Query query = new Query(new Criteria()
                .orOperator(
                        Criteria.where("ciudad").is(ciudad),
                        Criteria.where("fecha").lt(fechaHora)
                ));

        mongoTemplate.find(query, BackWebReservaEntity.class, "reservas")
                .forEach(backWebReservaEntity -> backWebReservaOutputDTOList
                        .add(new BackWebReservaOutputDTO(backWebReservaEntity)));

        return ResponseEntity.ok(backWebReservaOutputDTOList);
    }
}
