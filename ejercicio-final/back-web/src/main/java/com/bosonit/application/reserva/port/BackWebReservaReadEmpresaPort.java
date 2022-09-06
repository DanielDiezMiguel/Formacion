package com.bosonit.application.reserva.port;

import com.bosonit.infrastructure.reserva.controller.dto.BackWebSecurityInputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "back-web-feign", url = "http://localhost:8090")
public interface BackWebReservaReadEmpresaPort {

    @GetMapping("api/v0/security/token/")
    ResponseEntity<BackWebSecurityInputDTO> getToken(@RequestParam(value = "token") String token);
}
