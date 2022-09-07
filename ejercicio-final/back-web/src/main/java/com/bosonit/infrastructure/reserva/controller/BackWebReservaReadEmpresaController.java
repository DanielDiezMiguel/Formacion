package com.bosonit.infrastructure.reserva.controller;

import com.bosonit.application.reserva.port.BackWebReservaReadEmpresaPort;
import com.bosonit.application.reserva.port.BackWebReservaReadPort;
import com.bosonit.domain.no_collection.BackWebSecurityToken;
import com.bosonit.exception.Forbidden;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v0/reserva/token")
public class BackWebReservaReadEmpresaController {

    @Autowired
    BackWebReservaReadPort backWebReservaReadPort;

    @Autowired
    BackWebReservaReadEmpresaPort backWebReservaReadEmpresaPort;

    @GetMapping("{token}")
    public ResponseEntity getToken(
            @PathVariable(name = "token") String token,
            @RequestParam(value = "ciudad", required = false) String ciudad,
            @RequestParam(value = "condicion", required = false) String condicion,
            @RequestParam(value = "fecha", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) throws Exception {

        try {
            backWebReservaReadEmpresaPort.getToken(token);
            return backWebReservaReadPort.getAllReservas(ciudad, fecha, condicion);
        } catch (Exception e) {
            throw new Forbidden("Token invalido");
        }
    }

//    @GetMapping("{token}")
//    public ResponseEntity getToken(@PathVariable(name = "token") String token) {
//        try {
//            return backWebReservaReadEmpresaPort.getToken(token);
//        } catch (Exception e) {
//            throw new Forbidden("Token invalido");
//        }
//    }

//    @RestController
//    @RequestMapping("/api/v0/reserva")
//    public class BackWebReservaReadController {
//
//        @Autowired
//        BackWebReservaReadPort backWebReservaReadPort;
//
//        @GetMapping
//        public ResponseEntity<List<BackWebReservaOutputDTO>> getAllReservas(
//                @RequestParam(value = "ciudad", required = false) String ciudad,
//                @RequestParam(value = "condicion", required = false) String condicion,
//                @RequestParam(value = "fecha", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
//            return backWebReservaReadPort.getAllReservas(ciudad, fecha, condicion);
//        }
//    }
}
