package com.bosonit.infrastructure.reserva_disponible.controller;

import com.bosonit.application.reserva_disponible.port.BackEmpresaMailPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/disponible/correo")
public class BackEmpresaMailController {

    @Autowired
    BackEmpresaMailPort backEmpresaMailPort;

    @PostMapping
    public void sendMail(
            @RequestParam(value = "destinatario") String destinatario,
            @RequestParam(value = "asunto") String asunto,
            @RequestParam(value = "contenido") String contenido) {
        backEmpresaMailPort.sendEmail(destinatario, asunto, contenido);
    }
}
