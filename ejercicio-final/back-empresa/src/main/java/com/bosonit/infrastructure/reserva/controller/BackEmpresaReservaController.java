package com.bosonit.infrastructure.controller;

import com.bosonit.application.reserva.port.BackEmpresaReservaPort;
import com.bosonit.infrastructure.controller.dto.BackEmpresaReservaInputDTO;
import com.bosonit.infrastructure.controller.dto.BackEmpresaReservaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva")
public class BackEmpresaReservaController {

    @Autowired
    BackEmpresaReservaPort backEmpresaReservaPort;

    @PostMapping
    public ResponseEntity<BackEmpresaReservaOutputDTO> backEmpresaReservaOutputDTO(@RequestBody BackEmpresaReservaInputDTO backEmpresaReservaInputDTO) {
        return backEmpresaReservaPort.crearReserva(backEmpresaReservaInputDTO);
    }
}
