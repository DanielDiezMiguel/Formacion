package com.bosonit.application.security;

import com.bosonit.application.security.port.BackEmpresaSecurityCheckTokenPort;
import com.bosonit.infrastructure.security.controller.dto.BackEmpresaSecurityInputDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BackEmpresaSecurityCheckTokenUseCase implements BackEmpresaSecurityCheckTokenPort {

    @Override
    public HttpStatus checkToken(BackEmpresaSecurityInputDTO backEmpresaSecurityInputDTO, String authorization) {
        if (backEmpresaSecurityInputDTO.getToken().equals(authorization))
            return HttpStatus.OK;
        else return HttpStatus.FORBIDDEN;
    }
}
