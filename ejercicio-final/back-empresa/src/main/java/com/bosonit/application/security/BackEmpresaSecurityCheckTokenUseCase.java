package com.bosonit.application.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bosonit.application.security.port.BackEmpresaSecurityCheckTokenPort;
import com.bosonit.exception.Forbidden;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.bosonit.security.configuration.ConstantsConfiguration.SECRET;

@Service
public class BackEmpresaSecurityCheckTokenUseCase implements BackEmpresaSecurityCheckTokenPort {


    @Override
    public ResponseEntity checkToken(String token) {
        try {
            String verifyToken =
                    JWT.require(Algorithm.HMAC256(SECRET.getBytes()))
                            .build()
                            .verify(token)
                            .getToken();

            if (token.equals(verifyToken)) return ResponseEntity.ok().build();

        } catch (Exception e) {
            throw new Forbidden("Token invalido");
        }

        throw new Forbidden("Token invalido");
    }
}
