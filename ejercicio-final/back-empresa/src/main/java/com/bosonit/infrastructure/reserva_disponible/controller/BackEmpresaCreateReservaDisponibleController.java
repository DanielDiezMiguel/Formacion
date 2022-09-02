package com.bosonit.infrastructure.reserva_disponible.controller;

import com.bosonit.application.reserva_disponible.port.BackEmpresaCreateReservaDisponiblePort;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackEmpresaReservaDisponibleInputDTO;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackEmpresaReservaDisponibleOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/disponible")
public class BackEmpresaCreateReservaDisponibleController {

    @Autowired
    BackEmpresaCreateReservaDisponiblePort backEmpresaCreateReservaDisponiblePort;

    @PostMapping
    public ResponseEntity<BackEmpresaReservaDisponibleOutputDTO> crearReservaDisponible(
            @RequestBody BackEmpresaReservaDisponibleInputDTO backEmpresaReservaDisponibleInputDTO) {
        return backEmpresaCreateReservaDisponiblePort.crearReservaDisponible(backEmpresaReservaDisponibleInputDTO);
    }

}
