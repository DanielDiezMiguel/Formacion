package com.bosonit.infrastructure.reserva.controller;

import com.bosonit.application.reserva.port.BackEmpresaReservaReadPort;
import com.bosonit.exception.Forbidden;
import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v0/reserva")
public class BackEmpresaReservaReadController {

    @Autowired
    BackEmpresaReservaReadPort backEmpresaReservaReadPort;

    @GetMapping
    public ResponseEntity getToken(
            @RequestParam(value = "ciudad", required = false) String ciudad,
            @RequestParam(value = "condicion", required = false) String condicion,
            @RequestParam(value = "fecha", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {

        return backEmpresaReservaReadPort.getAllReservas(ciudad, fecha, condicion);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BackEmpresaReservaOutputDTO>> getAllReservas() {
        return backEmpresaReservaReadPort.getAllReservas();
    }
}
