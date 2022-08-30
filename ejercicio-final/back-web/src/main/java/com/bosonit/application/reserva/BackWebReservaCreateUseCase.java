package com.bosonit.application.reserva;

import com.bosonit.application.reserva.port.BackWebReservaCreatePort;
import com.bosonit.domain.reserva.BackWebReservaCollection;
import com.bosonit.exception.BadRequest;
import com.bosonit.infrastructure.controller.dto.BackWebReservaInputDTO;
import com.bosonit.infrastructure.controller.dto.BackWebReservaOutputDTO;
import com.bosonit.infrastructure.reserva.repository.mongodb.MongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BackWebReservaCreateUseCase implements BackWebReservaCreatePort {

    @Autowired
    MongoDBRepository mongoDBRepository;

    @Override
    public ResponseEntity<BackWebReservaOutputDTO> crearReserva(BackWebReservaInputDTO backWebReservaInputDTO) {
        try {
            return ResponseEntity.ok(new BackWebReservaOutputDTO(mongoDBRepository.save(new BackWebReservaCollection(backWebReservaInputDTO))));
        } catch (Exception e) {
            throw new BadRequest("Reserva inválida");
        }
    }
}