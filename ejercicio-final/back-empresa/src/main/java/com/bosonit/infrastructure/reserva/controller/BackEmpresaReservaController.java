package com.bosonit.infrastructure.reserva.controller;

import com.bosonit.application.reserva.port.BackEmpresaCreateReservaPort;
import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaInputDTO;
import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaOutputDTO;
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
    BackEmpresaCreateReservaPort backEmpresaCreateReservaPort;

    @PostMapping
    public ResponseEntity<BackEmpresaReservaOutputDTO> backEmpresaReservaOutputDTO(@RequestBody BackEmpresaReservaInputDTO backEmpresaReservaInputDTO) {
        return backEmpresaCreateReservaPort.crearReserva(backEmpresaReservaInputDTO);
    }
}
