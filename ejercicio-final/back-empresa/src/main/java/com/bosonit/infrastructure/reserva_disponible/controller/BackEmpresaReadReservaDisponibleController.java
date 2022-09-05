package com.bosonit.infrastructure.reserva_disponible.controller;

import com.bosonit.application.reserva_disponible.port.BackEmpresaReadReservaDisponiblePort;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackEmpresaReservaDisponibleOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/disponible/get")
public class BackEmpresaReadReservaDisponibleController {

    @Autowired
    BackEmpresaReadReservaDisponiblePort backEmpresaReadReservaDisponiblePort;

    @GetMapping
    public ResponseEntity<List<BackEmpresaReservaDisponibleOutputDTO>> getReservaDisponible(
            @RequestParam(value = "ciudad", required = false) String ciudad,
            @RequestParam(value = "condicion", required = false) String condicion,
            @RequestParam(value = "numeroPlazas", required = false) Integer numeroPlazas) {
        return backEmpresaReadReservaDisponiblePort.readReservaDisponible(ciudad, numeroPlazas, condicion);
    }
}
