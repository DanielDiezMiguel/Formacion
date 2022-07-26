package com.bosonit.Persona.infrastructure.controller;

import com.bosonit.Persona.application.port.ReadPersonaPort;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReadPersonaController {

    @Autowired
    ReadPersonaPort readPersonaPort;

    @GetMapping("/usuario/read/id/{id}")
    public PersonaOutputDTO getUsuarioByID(@PathVariable(value = "id") Integer id) {
        return readPersonaPort.getUsuarioByID(id);
    }

    @GetMapping("/usuario/read/all")
    public List<PersonaOutputDTO> getAllUsuarios() {
        return readPersonaPort.getAllUsuarios();
    }

    @GetMapping("/usuario/read/name/{nombre}")
    public List<PersonaOutputDTO> getUsuarioByName(@PathVariable(value = "nombre") String nombre) {
        return readPersonaPort.getUsuarioByName(nombre);
    }
}
