package com.bosonit.application.reserva;

import com.bosonit.application.reserva.port.BackWebReservaCreatePort;
import com.bosonit.domain.reserva.BackWebReservaCollection;
import com.bosonit.domain.reserva_disponible.BackWebReservaDisponibleCollection;
import com.bosonit.exception.BadRequest;
import com.bosonit.exception.UnprocesableException;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaInputDTO;
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
import java.util.List;

@Service
public class BackWebReservaCreateUseCase implements BackWebReservaCreatePort {

    @Autowired
    MongoDBRepository mongoDBRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity<BackWebReservaOutputDTO> crearReserva(BackWebReservaInputDTO backWebReservaInputDTO) {
        return ResponseEntity.ok(new BackWebReservaOutputDTO(mongoDBRepository
                .save(new BackWebReservaCollection(backWebReservaInputDTO))));
    }

//    @Override
//    public ResponseEntity<BackWebReservaOutputDTO> crearReserva(BackWebReservaInputDTO backWebReservaInputDTO) {
//        List<BackWebReservaDisponibleOutputDTO> backWebReservaDisponibleOutputDTOList = new ArrayList<>();
//        Query query = new Query();
//
//        query = new Query(new Criteria()
//                .andOperator(
//                        Criteria.where("ciudad").is(backWebReservaInputDTO.getCiudad()),
//                        Criteria.where("numeroPlazas").lt(41),
//                        Criteria.where("numeroPlazas").gt(0)
//                ));
//
//        mongoTemplate.find(query, BackWebReservaDisponibleCollection.class, "reservas-disponibles")
//                .forEach(backWebReservaDisponibleCollection -> backWebReservaDisponibleOutputDTOList
//                        .add(new BackWebReservaDisponibleOutputDTO(backWebReservaDisponibleCollection)));
//
//        if (backWebReservaDisponibleOutputDTOList.size() > 0)
//            return ResponseEntity.ok(
//                    new BackWebReservaOutputDTO(mongoDBRepository
//                            .save(new BackWebReservaCollection(backWebReservaInputDTO))));
//
//        else throw new BadRequest("Reserva inválida");
//    }
}