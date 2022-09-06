package com.bosonit.infrastructure.security.controller;

import com.bosonit.application.security.port.BackEmpresaSecurityCheckTokenPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/security/token")
public class BackEmpresaSecurityController {

    @Autowired
    BackEmpresaSecurityCheckTokenPort backEmpresaSecurityCheckTokenPort;

    @GetMapping("{token}")
    public ResponseEntity checkToken(@PathVariable(name = "token") String token) {
        return backEmpresaSecurityCheckTokenPort.checkToken(token);
    }
}
