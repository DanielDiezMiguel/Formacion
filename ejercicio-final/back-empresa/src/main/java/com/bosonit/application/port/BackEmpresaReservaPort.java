package com.bosonit.application.port;

import com.bosonit.infrastructure.controller.dto.BackEmpresaReservaInputDTO;
import com.bosonit.infrastructure.controller.dto.BackEmpresaReservaOutputDTO;
import org.springframework.http.ResponseEntity;

public interface BackEmpresaReservaPort {
    ResponseEntity<BackEmpresaReservaOutputDTO> crearReserva(BackEmpresaReservaInputDTO backEmpresaReservaInputDTO);
}
