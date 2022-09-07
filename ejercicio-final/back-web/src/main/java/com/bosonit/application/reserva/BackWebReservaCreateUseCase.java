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
}