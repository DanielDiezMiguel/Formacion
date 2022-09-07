package com.bosonit.application.reserva;

import com.bosonit.application.reserva.port.BackWebReservaReadPort;
import com.bosonit.domain.reserva.BackWebReservaCollection;
import com.bosonit.exception.BadRequest;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaOutputDTO;
import com.bosonit.infrastructure.reserva.repository.mongodb.MongoDBRepository;
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
    public ResponseEntity<List<BackWebReservaOutputDTO>>
    getAllReservas(String ciudad, Date fecha, String condicion) {

        List<BackWebReservaOutputDTO> backWebReservaOutputDTOList = new ArrayList<>();
        Query query = new Query();

        try {
            switch (condicion) {
                case "superior":
                    query = new Query(new Criteria()
                            .andOperator(
                                    Criteria.where("ciudad").is(ciudad),
                                    Criteria.where("fechaMs").gte(fecha.getTime())
                            ));
                    break;

                case "inferior":
                    query = new Query(new Criteria()
                            .andOperator(
                                    Criteria.where("ciudad").is(ciudad),
                                    Criteria.where("fechaMs").lte(fecha.getTime())
                            ));
                    break;

                case "ciudad":
                    query = new Query(Criteria.where("ciudad").is(ciudad));
                    break;
            }

            mongoTemplate.find(query, BackWebReservaCollection.class, "reservas")
                    .forEach(backWebReservaCollection -> backWebReservaOutputDTOList
                            .add(new BackWebReservaOutputDTO(backWebReservaCollection)));

            return ResponseEntity.ok(backWebReservaOutputDTOList);

        } catch (Exception e) {
            throw new BadRequest("Introduce una condicion: superior, inferior o ciudad");
        }
    }

    @Override
    public ResponseEntity<List<BackWebReservaOutputDTO>> getAllReservas() {
        List<BackWebReservaOutputDTO> backWebReservaOutputDTOList = new ArrayList<>();

        mongoDBRepository.findAll()
                .forEach(backWebReservaCollection -> backWebReservaOutputDTOList
                        .add(new BackWebReservaOutputDTO(backWebReservaCollection)));

        return ResponseEntity.ok(backWebReservaOutputDTOList);
    }
}