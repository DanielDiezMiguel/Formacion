package com.bosonit.application.reserva.port;

import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaInputDTO;
import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaOutputDTO;
import org.springframework.http.ResponseEntity;

public interface BackEmpresaReservaCreatePort {
    ResponseEntity<BackEmpresaReservaOutputDTO> crearReserva(BackEmpresaReservaInputDTO backEmpresaReservaInputDTO);
}
