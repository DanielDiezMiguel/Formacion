package com.bosonit.infrastructure.reserva.controller;

import com.bosonit.application.reserva.port.BackWebReservaCreatePort;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaInputDTO;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/reserva")
public class BackWebReservaCreateController {

    @Autowired
    BackWebReservaCreatePort backWebReservaCreatePort;

    @PostMapping
    public ResponseEntity<BackWebReservaOutputDTO> crearReserva(@RequestBody BackWebReservaInputDTO backWebReservaInputDTO) {
        return backWebReservaCreatePort.crearReserva(backWebReservaInputDTO);
    }

}
