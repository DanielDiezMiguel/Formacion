package com.bosonit.application.reserva;

import com.bosonit.application.reserva.port.BackEmpresaReservaReadPort;
import com.bosonit.domain.reserva.BackEmpresaReservaCollection;
import com.bosonit.exception.BadRequest;
import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaOutputDTO;
import com.bosonit.infrastructure.reserva.repository.mongodb.MongoDBRepositoryEmpresa;
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
public class BackEmpresaReservaReadUseCase implements BackEmpresaReservaReadPort {

    @Autowired
    MongoDBRepositoryEmpresa mongoDBRepositoryEmpresa;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity<List<BackEmpresaReservaOutputDTO>>
    getAllReservas(String ciudad, Date fecha, String condicion) {

        List<BackEmpresaReservaOutputDTO> backWebReservaOutputDTOList = new ArrayList<>();
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

            mongoTemplate.find(query, BackEmpresaReservaCollection.class, "reservas")
                    .forEach(backWebReservaCollection -> backWebReservaOutputDTOList
                            .add(new BackEmpresaReservaOutputDTO(backWebReservaCollection)));

            return ResponseEntity.ok(backWebReservaOutputDTOList);

        } catch (Exception e) {
            throw new BadRequest("Introduce una condicion: superior, inferior o ciudad");
        }
    }

    @Override
    public ResponseEntity<List<BackEmpresaReservaOutputDTO>> getAllReservas() {
        List<BackEmpresaReservaOutputDTO> backWebReservaOutputDTOList = new ArrayList<>();

        mongoDBRepositoryEmpresa.findAll()
                .forEach(backWebReservaCollection -> backWebReservaOutputDTOList
                        .add(new BackEmpresaReservaOutputDTO(backWebReservaCollection)));

        return ResponseEntity.ok(backWebReservaOutputDTOList);
    }
}