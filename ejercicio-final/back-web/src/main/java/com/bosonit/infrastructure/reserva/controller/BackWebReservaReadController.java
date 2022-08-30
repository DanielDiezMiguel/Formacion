package com.bosonit.infrastructure.controller;

import com.bosonit.application.reserva.port.BackWebReservaReadPort;
import com.bosonit.infrastructure.controller.dto.BackWebReservaOutputDTO;
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
@RequestMapping("/api/v0/disponible")
public class BackWebReservaReadController {

    @Autowired
    BackWebReservaReadPort backWebReservaReadPort;

    @GetMapping
    public ResponseEntity<List<BackWebReservaOutputDTO>> backWebReservaOutputDTOList(
            @RequestParam(value = "ciudad", required = false) String ciudad,
            @RequestParam(value = "fecha", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
            @RequestParam(value = "condicion", required = false) String condicion) {
        return backWebReservaReadPort.getAllReservas(ciudad, fecha, condicion);
    }
}
