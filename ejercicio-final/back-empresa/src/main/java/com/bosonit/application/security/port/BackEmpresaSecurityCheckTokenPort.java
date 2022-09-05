package com.bosonit.application.security.port;

import com.bosonit.infrastructure.security.controller.dto.BackEmpresaSecurityInputDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface BackEmpresaSecurityCheckTokenPort {
    HttpStatus checkToken(BackEmpresaSecurityInputDTO backEmpresaSecurityInputDTO, String token);
}
