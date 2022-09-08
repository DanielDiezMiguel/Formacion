package com.bosonit.infrastructure.reserva.controller;

import com.bosonit.application.reserva.port.BackEmpresaReservaCreatePort;
import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/reserva")
public class BackEmpresaReservaController {

    @Autowired
    BackEmpresaReservaCreatePort backEmpresaReservaCreatePort;

    @PostMapping
    public ResponseEntity crearReserva(@RequestBody BackEmpresaReservaInputDTO backEmpresaReservaInputDTO) {
        return backEmpresaReservaCreatePort.crearReserva(backEmpresaReservaInputDTO);
    }
}
