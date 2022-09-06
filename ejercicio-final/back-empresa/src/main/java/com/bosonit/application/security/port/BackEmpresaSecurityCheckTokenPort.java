package com.bosonit.application.security.port;

import com.bosonit.domain.no_collection.BackEmpresaSecurityToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface BackEmpresaSecurityCheckTokenPort {
    ResponseEntity checkToken(BackEmpresaSecurityToken backEmpresaSecurityToken, String token);
}
