package com.bosonit.infrastructure.reserva_disponible.controller;

import com.bosonit.application.reserva_disponible.port.BackWebReservaDisponiblePort;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleInputDTO;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/disponible")
public class BackWebReservaDisponibleController {

    @Autowired
    BackWebReservaDisponiblePort backWebReservaDisponiblePort;

    @PostMapping
    public ResponseEntity<BackWebReservaDisponibleOutputDTO> crearReservaDisponible(@RequestBody BackWebReservaDisponibleInputDTO backWebReservaDisponibleInputDTO) {
        return backWebReservaDisponiblePort.crearReservaDisponible(backWebReservaDisponibleInputDTO);
    }
}
