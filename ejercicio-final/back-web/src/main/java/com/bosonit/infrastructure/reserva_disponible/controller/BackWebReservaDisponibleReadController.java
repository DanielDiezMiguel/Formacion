package com.bosonit.infrastructure.reserva_disponible.controller;

import com.bosonit.application.reserva_disponible.port.BackWebReservaDisponibleReadPort;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaOutputDTO;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v0/disponible")
public class BackWebReservaDisponibleReadController {

    @Autowired
    BackWebReservaDisponibleReadPort backWebReservaDisponibleReadPort;

    @GetMapping
    public ResponseEntity<List<BackWebReservaDisponibleOutputDTO>> backWebReservaOutputDTOList(
            @RequestParam(value = "ciudad", required = false) String ciudad,
            @RequestParam(value = "fecha", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
            @RequestParam(value = "condicion", required = false) String condicion) {
        return backWebReservaDisponibleReadPort.getAllReservas(ciudad, fecha, condicion);
    }
}
