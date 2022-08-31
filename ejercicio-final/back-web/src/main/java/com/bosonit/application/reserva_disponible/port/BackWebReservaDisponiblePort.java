package com.bosonit.application.reserva_disponible.port;

import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleInputDTO;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleOutputDTO;
import org.springframework.http.ResponseEntity;

public interface BackWebReservaDisponiblePort {
//    ResponseEntity<BackWebReservaDisponibleOutputDTO> crearReservaDisponible(BackWebReservaDisponibleInputDTO backWebReservaDisponibleInputDTO);

    ResponseEntity<BackWebReservaDisponibleOutputDTO> crearReservaDisponible(BackWebReservaDisponibleInputDTO backWebReservaDisponibleInputDTO, String ciudad);
}
