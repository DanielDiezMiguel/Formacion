package com.bosonit.application.reserva.port;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BACK-EMPRESA")
public interface BackWebReservaReadFeignSecurity {

    @GetMapping("/api/v0/security/token/{token}")
    ResponseEntity getToken(@PathVariable(name = "token") String token);

}
