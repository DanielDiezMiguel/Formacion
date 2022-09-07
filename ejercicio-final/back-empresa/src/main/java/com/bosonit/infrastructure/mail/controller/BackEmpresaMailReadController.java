package com.bosonit.infrastructure.mail.controller;

import com.bosonit.application.mail.port.BackEmpresaMailReadPort;
import com.bosonit.infrastructure.mail.controller.dto.BackEmpresaMailOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v0/correo/all")
public class BackEmpresaMailReadController {

    @Autowired
    BackEmpresaMailReadPort backEmpresaMailReadPort;

    @GetMapping
    public ResponseEntity<List<BackEmpresaMailOutputDTO>> getAllEmails() {
        return backEmpresaMailReadPort.getEmails();
    }
}
