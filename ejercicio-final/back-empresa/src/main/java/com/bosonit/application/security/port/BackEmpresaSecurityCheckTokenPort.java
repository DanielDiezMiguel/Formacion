package com.bosonit.application.security.port;

import org.springframework.http.ResponseEntity;

public interface BackEmpresaSecurityCheckTokenPort {
    ResponseEntity checkToken(String token);
}
