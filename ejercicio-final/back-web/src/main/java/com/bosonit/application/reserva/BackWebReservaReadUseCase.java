package com.bosonit.application.reserva;

import com.bosonit.application.reserva.port.BackWebReservaReadPort;
import com.bosonit.domain.reserva.BackWebReservaCollection;
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
    public ResponseEntity<List<BackWebReservaOutputDTO>> getAllReservas(String ciudad, Date fecha, String condicion) {
        List<BackWebReservaOutputDTO> backWebReservaOutputDTOList = new ArrayList<>();

        if (condicion != null) {
            switch (condicion) {
                case "inferior":
                    Query inferior = new Query(new Criteria()
                            .orOperator(
                                    Criteria.where("ciudad").is(ciudad),
                                    Criteria.where("fechaMs").lte(fecha.getTime())
                            ));
                    mongoTemplate.find(inferior, BackWebReservaCollection.class, "reservas")
                            .forEach(backWebReservaCollection -> backWebReservaOutputDTOList
                                    .add(new BackWebReservaOutputDTO(backWebReservaCollection)));
                    break;

                case "superior":
                    Query superior = new Query(new Criteria()
                            .orOperator(
                                    Criteria.where("ciudad").is(ciudad),
                                    Criteria.where("fechaMs").gte(fecha.getTime())
                            ));
                    mongoTemplate.find(superior, BackWebReservaCollection.class, "reservas")
                            .forEach(backWebReservaCollection -> backWebReservaOutputDTOList
                                    .add(new BackWebReservaOutputDTO(backWebReservaCollection)));
                    break;
            }

        } else {
            Query query = new Query(Criteria.where("ciudad").is(ciudad));
            mongoTemplate.find(query, BackWebReservaCollection.class, "reservas")
                    .forEach(backWebReservaCollection -> backWebReservaOutputDTOList
                            .add(new BackWebReservaOutputDTO(backWebReservaCollection)));
        }
        return ResponseEntity.ok(backWebReservaOutputDTOList);
    }
}
