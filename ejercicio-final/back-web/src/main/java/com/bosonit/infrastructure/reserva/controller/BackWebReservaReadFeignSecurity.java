package com.bosonit.infrastructure.reserva.controller;

import com.bosonit.application.reserva.port.BackWebReservaReadPort;
import com.bosonit.exception.Forbidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v0/reserva/token")
public class BackWebReservaReadFeignSecurity {

    @Autowired
    BackWebReservaReadPort backWebReservaReadPort;

    @Autowired
    com.bosonit.application.reserva.port.BackWebReservaReadFeignSecurity backWebReservaReadFeignSecurity;

    @GetMapping("{token}")
    public ResponseEntity getToken(
            @PathVariable(name = "token") String token,
            @RequestParam(value = "ciudad", required = false) String ciudad,
            @RequestParam(value = "condicion", required = false) String condicion,
            @RequestParam(value = "fecha", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) throws Exception {

        try {
            backWebReservaReadFeignSecurity.getToken(token);
            return backWebReservaReadPort.getAllReservas(ciudad, fecha, condicion);

        } catch (Exception e) {
            throw new Forbidden("Token invalido");
        }
    }
}
