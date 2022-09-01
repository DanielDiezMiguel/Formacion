package com.bosonit.application.reserva_disponible;

import com.bosonit.application.reserva_disponible.port.BackEmpresaReadReservaDisponiblePort;
import com.bosonit.domain.reserva_disponible.BackEmpresaReservaDisponibleCollection;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackEmpresaReservaDisponibleInputDTO;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackEmpresaReservaDisponibleOutputDTO;
import com.bosonit.infrastructure.reserva_disponible.repository.mongoDB.MongoDBRespositoryDisponible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BackEmpresaReadReservaDisponibleUseCase implements BackEmpresaReadReservaDisponiblePort {

    @Autowired
    MongoDBRespositoryDisponible mongoDBRespositoryDisponible;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity<List<BackEmpresaReservaDisponibleOutputDTO>> readReservaDisponible(
            String ciudad, Integer numeroPlazasInferior, Integer numeroPlazasSuperior) {

        List<BackEmpresaReservaDisponibleOutputDTO> backEmpresaReservaDisponibleOutputDTOList = new ArrayList<>();

        Query query = new Query(new Criteria()
                .andOperator(
                        (Criteria.where("ciudad").is(ciudad))
                                .orOperator(
                                        Criteria.where("numeroPlazas").lte(numeroPlazasInferior),
                                        Criteria.where("numeroPlazas").gte(numeroPlazasSuperior))
                ));

        mongoTemplate.find(query, BackEmpresaReservaDisponibleCollection.class, "reservas-disponibles")
                .forEach(backEmpresaReservaDisponibleCollection -> backEmpresaReservaDisponibleOutputDTOList
                        .add(new BackEmpresaReservaDisponibleOutputDTO(backEmpresaReservaDisponibleCollection)));

        return ResponseEntity.ok(backEmpresaReservaDisponibleOutputDTOList);
    }

}