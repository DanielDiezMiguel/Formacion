package com.bosonit.application.reserva_disponible;

import com.bosonit.application.reserva_disponible.port.BackWebReservaDisponiblePort;
import com.bosonit.domain.reserva_disponible.BackWebReservaDisponibleCollection;
import com.bosonit.exception.BadRequest;
import com.bosonit.exception.UnprocesableException;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleInputDTO;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleOutputDTO;
import com.bosonit.infrastructure.reserva_disponible.repository.mongodb.MongoDBRepositoryDisponible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BackWebReservaDisponibleCreateUseCase implements BackWebReservaDisponiblePort {

    @Autowired
    MongoDBRepositoryDisponible mongoDBRepositoryDisponible;

    @Override
    public ResponseEntity<BackWebReservaDisponibleOutputDTO> crearReservaDisponible(BackWebReservaDisponibleInputDTO backWebReservaDisponibleInputDTO) {
        try {
            if (backWebReservaDisponibleInputDTO.getNumeroPlazas() <= 40)
                return ResponseEntity.ok(new BackWebReservaDisponibleOutputDTO(mongoDBRepositoryDisponible.save(new BackWebReservaDisponibleCollection(backWebReservaDisponibleInputDTO))));
        } catch (Exception e) {
            throw new BadRequest("Reserva disponible inválida");
        }
        throw new UnprocesableException("Introduce un número inferior a 40 plazas");
    }
}
