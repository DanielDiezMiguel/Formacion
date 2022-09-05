package com.bosonit.application.reserva_disponible.port;

import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaOutputDTO;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface BackWebReservaDisponibleReadPort {
//    ResponseEntity<List<BackWebReservaDisponibleOutputDTO>> getAllReservas(String ciudad, Date fecha, String condicion);
//    ResponseEntity<List<BackWebReservaDisponibleOutputDTO>> getAllReservas(
//            String ciudad, Date fechaInferior, Date fechaSuperior);

    ResponseEntity<List<BackWebReservaDisponibleOutputDTO>> getAllReservas(
            String ciudad, Date fecha, String condicion);
}
