package com.bosonit.Persona.application.port;

import com.bosonit.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simpleFeign", url = "http://localhost:8080")
public interface FeignPersonaPort {
    @GetMapping("/profesor/id/{httpCode}")
    ResponseEntity<ProfesorOutputDTO> callServer(@PathVariable("httpCode") String httpCode);
}
