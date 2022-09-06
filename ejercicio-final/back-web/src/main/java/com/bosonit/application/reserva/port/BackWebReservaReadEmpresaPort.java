package com.bosonit.application.reserva.port;

import com.bosonit.domain.no_collection.BackWebSecurityToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "back-web-feign", url = "http://localhost:8090")
public interface BackWebReservaReadEmpresaPort {

    @GetMapping("/api/v0/security/token/")
    ResponseEntity getToken(String token);

}
