package com.bosonit.application.reserva.port;

import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface BackEmpresaReservaReadPort {

    ResponseEntity<List<BackEmpresaReservaOutputDTO>>
    getAllReservas(String ciudad, Date fecha, String condicion);

    ResponseEntity<List<BackEmpresaReservaOutputDTO>> getAllReservas();
}
