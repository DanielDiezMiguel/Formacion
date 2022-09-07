package com.bosonit.infrastructure.mail.controller;

import com.bosonit.application.mail.port.BackEmpresaMailCreatePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/disponible/correo")
public class BackEmpresaMailCreateController {

    @Autowired
    BackEmpresaMailCreatePort backEmpresaMailCreatePort;

    @PostMapping
    public ResponseEntity sendMail(
            @RequestParam(value = "destinatario") String destinatario,
            @RequestParam(value = "asunto") String asunto,
            @RequestParam(value = "contenido") String contenido) {
        return backEmpresaMailCreatePort.sendEmail(destinatario, asunto, contenido);
    }
}
