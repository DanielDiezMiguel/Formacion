package com.bosonit.application.reserva_disponible;

import com.bosonit.application.reserva_disponible.port.BackWebReservaDisponibleReadPort;
import com.bosonit.domain.reserva_disponible.BackWebReservaDisponibleCollection;
import com.bosonit.exception.BadRequest;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleOutputDTO;
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
public class BackWebReservaDisponibleDisponibleReadUseCase implements BackWebReservaDisponibleReadPort {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity<List<BackWebReservaDisponibleOutputDTO>>
    getAllReservas(String ciudad, Date fecha, String condicion) {

        List<BackWebReservaDisponibleOutputDTO> backWebReservaDisponibleOutputDTOList = new ArrayList<>();
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

            mongoTemplate.find(query, BackWebReservaDisponibleCollection.class, "reservas-disponibles")
                    .forEach(backWebReservaCollection -> backWebReservaDisponibleOutputDTOList
                            .add(new BackWebReservaDisponibleOutputDTO(backWebReservaCollection)));

            return ResponseEntity.ok(backWebReservaDisponibleOutputDTOList);

        } catch (Exception e) {
            throw new BadRequest("Introduce una condicion: superior, inferior o ciudad");
        }
    }
}

