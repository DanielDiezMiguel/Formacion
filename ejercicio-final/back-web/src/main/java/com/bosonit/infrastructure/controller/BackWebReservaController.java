package com.bosonit.infrastructure.controller;

import com.bosonit.application.port.BackWebReservaPort;
import com.bosonit.infrastructure.controller.dto.BackWebReservaInputDTO;
import com.bosonit.infrastructure.controller.dto.BackWebReservaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/reserva")
public class BackWebReservaController {

    @Autowired
    BackWebReservaPort backWebReservaPort;

    @PostMapping
    public BackWebReservaOutputDTO crearReserva(@RequestBody BackWebReservaInputDTO backWebReservaInputDTO) {
        return backWebReservaPort.crearReserva(backWebReservaInputDTO);
    }
}
