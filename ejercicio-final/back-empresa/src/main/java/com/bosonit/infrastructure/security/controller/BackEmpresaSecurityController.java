package com.bosonit.infrastructure.security.controller;

import com.bosonit.application.security.port.BackEmpresaSecurityCheckTokenPort;
import com.bosonit.domain.no_collection.BackEmpresaSecurityToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/security/token")
public class BackEmpresaSecurityController {

    @Autowired
    BackEmpresaSecurityCheckTokenPort backEmpresaSecurityCheckTokenPort;

    @GetMapping
    public ResponseEntity checkToken(
            @RequestBody BackEmpresaSecurityToken backEmpresaSecurityToken,
            @RequestParam(value = "token") String token) {
        return backEmpresaSecurityCheckTokenPort.checkToken(backEmpresaSecurityToken, token);
    }
}
