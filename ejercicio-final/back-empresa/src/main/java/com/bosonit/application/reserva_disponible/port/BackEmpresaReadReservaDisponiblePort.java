package com.bosonit.application.reserva_disponible.port;


import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackEmpresaReservaDisponibleInputDTO;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackEmpresaReservaDisponibleOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BackEmpresaReadReservaDisponiblePort {

    ResponseEntity<List<BackEmpresaReservaDisponibleOutputDTO>> readReservaDisponible(
            String ciudad, Integer numeroPlazasInferior, Integer numeroPlazasSuperior);
}
