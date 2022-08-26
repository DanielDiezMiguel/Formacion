package com.bosonit.application.port;

import com.bosonit.infrastructure.controller.dto.BackWebReservaInputDTO;
import com.bosonit.infrastructure.controller.dto.BackWebReservaOutputDTO;

public interface BackWebReservaPort {
    BackWebReservaOutputDTO crearReserva(BackWebReservaInputDTO backWebReservaInputDTO);
}
