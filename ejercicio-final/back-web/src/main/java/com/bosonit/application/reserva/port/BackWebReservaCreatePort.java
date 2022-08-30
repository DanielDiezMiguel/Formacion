package com.bosonit.application.reserva.port;

import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaInputDTO;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaOutputDTO;
import org.springframework.http.ResponseEntity;

public interface BackWebReservaCreatePort {

    ResponseEntity<BackWebReservaOutputDTO> crearReserva(BackWebReservaInputDTO backWebReservaInputDTO);
}
