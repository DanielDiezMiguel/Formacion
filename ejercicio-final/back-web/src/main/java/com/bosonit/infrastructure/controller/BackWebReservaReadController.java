package com.bosonit.infrastructure.controller;

import com.bosonit.application.port.BackWebReservaReadPort;
import com.bosonit.infrastructure.controller.dto.BackWebReservaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v0/disponible")
public class BackWebReservaReadController {

    @Autowired
    BackWebReservaReadPort backWebReservaReadPort;

    @GetMapping
    public ResponseEntity<List<BackWebReservaOutputDTO>> backWebReservaOutputDTOList(
            @RequestParam(value = "ciudad") String ciudad,
            @RequestParam(value = "fechaHoraInferior", required = false) Date fechaHoraInferior,
            @RequestParam(value = "fechaHoraSuperior", required = false) Date fechaHoraSuperior) {
        return backWebReservaReadPort.getAllReservas(ciudad, fechaHoraInferior, fechaHoraSuperior);
    }
}
