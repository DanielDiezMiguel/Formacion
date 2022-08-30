package com.bosonit.application.reserva.port;

import com.bosonit.infrastructure.controller.dto.BackWebReservaInputDTO;
import com.bosonit.infrastructure.controller.dto.BackWebReservaOutputDTO;
import org.springframework.http.ResponseEntity;

public interface BackWebReservaCreatePort {

    ResponseEntity<BackWebReservaOutputDTO> crearReserva(BackWebReservaInputDTO backWebReservaInputDTO);
}
