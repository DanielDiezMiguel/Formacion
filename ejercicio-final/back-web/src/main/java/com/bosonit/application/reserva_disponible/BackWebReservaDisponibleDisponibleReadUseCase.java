package com.bosonit.application.reserva_disponible;

import com.bosonit.application.reserva_disponible.port.BackWebReservaDisponibleReadPort;
import com.bosonit.domain.reserva.BackWebReservaCollection;
import com.bosonit.domain.reserva_disponible.BackWebReservaDisponibleCollection;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaOutputDTO;
import com.bosonit.infrastructure.reserva.repository.mongodb.MongoDBRepository;
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
    public ResponseEntity<List<BackWebReservaDisponibleOutputDTO>> getAllReservas(String ciudad, Date fecha, String condicion) {
        List<BackWebReservaDisponibleOutputDTO> backWebReservaOutputDTOList = new ArrayList<>();

        if (condicion != null) {
            switch (condicion) {
                case "inferior":
                    Query inferior = new Query(new Criteria()
                            .orOperator(
                                    Criteria.where("ciudad").is(ciudad),
                                    Criteria.where("fechaMs").lte(fecha.getTime())
                            ));
                    mongoTemplate.find(inferior, BackWebReservaDisponibleCollection.class, "reservas-disponibles")
                            .forEach(backWebReservaCollection -> backWebReservaOutputDTOList
                                    .add(new BackWebReservaDisponibleOutputDTO(backWebReservaCollection)));
                    break;

                case "superior":
                    Query superior = new Query(new Criteria()
                            .orOperator(
                                    Criteria.where("ciudad").is(ciudad),
                                    Criteria.where("fechaMs").gte(fecha.getTime())
                            ));
                    mongoTemplate.find(superior, BackWebReservaDisponibleCollection.class, "reservas-disponibles")
                            .forEach(backWebReservaCollection -> backWebReservaOutputDTOList
                                    .add(new BackWebReservaDisponibleOutputDTO(backWebReservaCollection)));
                    break;
            }

        } else {
            Query query = new Query(Criteria.where("ciudad").is(ciudad));
            mongoTemplate.find(query, BackWebReservaDisponibleCollection.class, "reservas-disponibles")
                    .forEach(backWebReservaCollection -> backWebReservaOutputDTOList
                            .add(new BackWebReservaDisponibleOutputDTO(backWebReservaCollection)));
        }
        return ResponseEntity.ok(backWebReservaOutputDTOList);
    }
}
