package com.bosonit.infrastructure.reserva.controller;

import com.bosonit.application.reserva.port.BackWebReservaReadPort;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaOutputDTO;
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
@RequestMapping("/api/v0/reserva")
public class BackWebReservaReadController {

    @Autowired
    BackWebReservaReadPort backWebReservaReadPort;

    @GetMapping("/all")
    public ResponseEntity<List<BackWebReservaOutputDTO>> getAllReservas() {
        return backWebReservaReadPort.getAllReservas();
    }
}
