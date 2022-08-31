package com.bosonit.infrastructure.reserva_disponible.controller;

import com.bosonit.application.reserva_disponible.port.BackWebReservaDisponiblePort;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleInputDTO;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/disponible")
public class BackWebReservaDisponibleCreateController {

    @Autowired
    BackWebReservaDisponiblePort backWebReservaDisponiblePort;

    @PostMapping
    public ResponseEntity<BackWebReservaDisponibleOutputDTO> crearReservaDisponible(
            @RequestBody BackWebReservaDisponibleInputDTO backWebReservaDisponibleInputDTO,
            @RequestParam(value = "ciudad") String ciudad) {
        return backWebReservaDisponiblePort.crearReservaDisponible(backWebReservaDisponibleInputDTO, ciudad);
    }
}
