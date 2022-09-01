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
            @RequestParam(value = "ciudad") String ciudad,
            @RequestParam(value = "numeroPlazasInferior", required = false) Integer numeroPlazasInferior,
            @RequestParam(value = "numeroPlazasSuperior", required = false) Integer numeroPlazasSuperior) {
        return backEmpresaReadReservaDisponiblePort.readReservaDisponible(ciudad, numeroPlazasInferior, numeroPlazasSuperior);
    }
}
