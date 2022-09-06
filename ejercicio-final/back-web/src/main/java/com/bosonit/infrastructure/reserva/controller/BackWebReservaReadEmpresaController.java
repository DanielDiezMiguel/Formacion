package com.bosonit.infrastructure.reserva.controller;

import com.bosonit.application.reserva.port.BackWebReservaReadEmpresaPort;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebSecurityInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/reserva/token")
public class BackWebReservaReadEmpresaController {

    @Autowired
    BackWebReservaReadEmpresaPort backWebReservaReadEmpresaPort;

    @GetMapping
    public ResponseEntity<BackWebSecurityInputDTO> getToken(String token) {
        ResponseEntity<BackWebSecurityInputDTO> backWebSecurityInputDTOResponseEntity =
                backWebReservaReadEmpresaPort.getToken(token);
        return backWebSecurityInputDTOResponseEntity;
    }
}
