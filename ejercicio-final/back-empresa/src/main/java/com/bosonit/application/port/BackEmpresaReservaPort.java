package com.bosonit.application.port;

import com.bosonit.infrastructure.controller.dto.BackEmpresaReservaInputDTO;
import com.bosonit.infrastructure.controller.dto.BackEmpresaReservaOutputDTO;
public interface BackEmpresaReservaPort {

    BackEmpresaReservaOutputDTO crearReserva(BackEmpresaReservaInputDTO backEmpresaReservaInputDTO);
}
