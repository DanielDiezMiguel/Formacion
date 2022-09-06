package com.bosonit.application.security;

import com.bosonit.application.security.port.BackEmpresaSecurityCheckTokenPort;
import com.bosonit.domain.no_collection.BackEmpresaSecurityToken;
import com.bosonit.exception.BadRequest;
import com.bosonit.exception.Forbidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BackEmpresaSecurityCheckTokenUseCase implements BackEmpresaSecurityCheckTokenPort {

    @Override
    public ResponseEntity checkToken(BackEmpresaSecurityToken backEmpresaSecurityToken, String token) {
        if (backEmpresaSecurityToken.getToken().equals(token)) return ResponseEntity.ok(token);
        else throw new Forbidden("Token invalido");
    }
}
