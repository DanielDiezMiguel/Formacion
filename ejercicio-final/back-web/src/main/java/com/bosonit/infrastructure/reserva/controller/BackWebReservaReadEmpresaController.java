package com.bosonit.infrastructure.reserva.controller;

import com.bosonit.application.reserva.port.BackWebReservaReadEmpresaPort;
import com.bosonit.domain.no_collection.BackWebSecurityToken;
import com.bosonit.exception.Forbidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/reserva/token")
public class BackWebReservaReadEmpresaController {

    @Autowired
    BackWebReservaReadEmpresaPort backWebReservaReadEmpresaPort;

    @GetMapping("{token}")
    public ResponseEntity getToken(@PathVariable(name = "token") String token) {
        try {
            return backWebReservaReadEmpresaPort.getToken(token);
        } catch (Exception e) {
            throw new Forbidden("Token invalido");
        }
    }
}
