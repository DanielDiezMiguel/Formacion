package com.bosonit.application.reserva.port;

import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface BackWebReservaReadPort {
    ResponseEntity<List<BackWebReservaOutputDTO>> getAllReservas(String ciudad, Date fecha, String condicion);

}
