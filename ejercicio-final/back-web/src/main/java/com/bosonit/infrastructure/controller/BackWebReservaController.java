package com.bosonit.infrastructure.controller;

import com.bosonit.application.port.BackWebReservaPort;
import com.bosonit.infrastructure.controller.dto.BackWebReservaInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0")
public class BackWebReservaController {

    @Autowired
    BackWebReservaPort backWebReservaPort;

    @PostMapping("crearReserva")
    public void crearReserva(@RequestBody BackWebReservaInputDTO backWebReservaInputDTO) {
        backWebReservaPort.crearReserva(backWebReservaInputDTO);
    }
}
