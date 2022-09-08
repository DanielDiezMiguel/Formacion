package com.bosonit.infrastructure.mail.controller;

import com.bosonit.application.mail.port.BackEmpresaMailUpdatePort;
import com.bosonit.infrastructure.mail.controller.dto.BackEmpresaMailInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/correo/update")
public class BackEmpresaMailUpdateController {

    @Autowired
    BackEmpresaMailUpdatePort backEmpresaMailUpdatePort;

    @PutMapping
    public ResponseEntity updateMail(
            @RequestBody BackEmpresaMailInputDTO backEmpresaMailInputDTO,
            String destinatario, String asunto, String contenido) {

        return backEmpresaMailUpdatePort.sendEmail(backEmpresaMailInputDTO, destinatario, asunto, contenido);
    }

}
