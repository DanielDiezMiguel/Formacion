package com.bosonit.Persona.infrastructure.controller;

import com.bosonit.Persona.application.port.ReadPersonaPort;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.Profesor.domain.ProfesorEntity;
import com.bosonit.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/id/{id}")
    public PersonaOutputDTO getUsuarioByID(@PathVariable(value = "id") String id, @RequestParam(defaultValue = "persona", required = false) String outputType) throws Exception {
        return readPersonaPort.getPersonaByID(id, outputType);
    }

    @GetMapping("/all/all")
    public List<PersonaOutputDTO> getAllUsuarios(@RequestParam(defaultValue = "persona", required = false) String outputType) {
        return readPersonaPort.getAllUsuarios(outputType);
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaOutputDTO> getUsuarioByName(@PathVariable(value = "nombre") String nombre, @RequestParam(defaultValue = "persona", required = false) String outputType) {
        return readPersonaPort.getPersonaByName(nombre, outputType);
    }

    @GetMapping("/profesor/profesor/{id}")
    public ProfesorOutputDTO getProfesorRestTemplate(@PathVariable String id) {
        System.out.println("Llamando a getProfesorRestTemplate");
        String url = "http://localhost:8080/profesor/id/" + id;
        ResponseEntity<ProfesorOutputDTO> responseEntity = new RestTemplate().getForEntity(url, ProfesorOutputDTO.class);
        System.out.println("Despues de  a getProfesorRestTemplate");
        if(responseEntity.getStatusCode() == HttpStatus.OK)
            return responseEntity.getBody();
        else
            throw new RuntimeException("El server no respondió OK");

    }
}
