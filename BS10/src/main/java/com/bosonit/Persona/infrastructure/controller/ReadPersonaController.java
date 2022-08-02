package com.bosonit.Persona.infrastructure.controller;

import com.bosonit.Persona.application.port.FeignPersonaPort;
import com.bosonit.Persona.application.port.ReadPersonaPort;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("persona")
public class ReadPersonaController {

    @Autowired
    ReadPersonaPort readPersonaPort;

    @Autowired
    FeignPersonaPort feignPersonaPort;

    @GetMapping("/id/{id}")
    @Operation(summary = "Obtener Persona por ID")
    public PersonaOutputDTO getUsuarioByID(@PathVariable(value = "id") String id, @RequestParam(defaultValue = "persona", required = false) String outputType) throws Exception {
        return readPersonaPort.getPersonaByID(id, outputType);
    }

    @GetMapping("/all/all")
    @Operation(summary = "Obtener todas las Personas")
    public List<PersonaOutputDTO> getAllUsuarios(@RequestParam(defaultValue = "persona", required = false) String outputType) {
        return readPersonaPort.getAllUsuarios(outputType);
    }

    @GetMapping("/nombre/{nombre}")
    @Operation(summary = "Obtener Personas por nombre")
    public List<PersonaOutputDTO> getUsuarioByName(@PathVariable(value = "nombre") String nombre, @RequestParam(defaultValue = "persona", required = false) String outputType) {
        return readPersonaPort.getPersonaByName(nombre, outputType);
    }

    @GetMapping("/profesor/profesor/{id}")
    @Operation(summary = "Obtener Profesor con RestTemplate")
    public ProfesorOutputDTO getProfesorByRestTemplate(@PathVariable String id) {
        System.out.println("Llamando a getProfesorRestTemplate");
        String url = "http://localhost:8080/profesor/id/" + id;
        ResponseEntity<ProfesorOutputDTO> responseEntity = new RestTemplate().getForEntity(url, ProfesorOutputDTO.class);
        System.out.println("Despues de  a getProfesorRestTemplate");
        if(responseEntity.getStatusCode() == HttpStatus.OK)
            return responseEntity.getBody();
        else
            throw new RuntimeException("El server no respondió OK");

    }

    @GetMapping("/profesor/feign/{code}")
    @Operation(summary = "Obtener Profesor con Feign")
    public ResponseEntity<ProfesorOutputDTO> callServerByFeign(@PathVariable(name = "code") String code) {
        ResponseEntity<ProfesorOutputDTO> personaOutputDTOResponseEntity = feignPersonaPort.callServer(code);
        return personaOutputDTOResponseEntity;
    }

}
