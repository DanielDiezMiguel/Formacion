package com.bosonit.Persona.infrastructure.controller;

import com.bosonit.Persona.application.port.ReadPersonaPort;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("persona")
public class ReadPersonaController {

    @Autowired
    ReadPersonaPort readPersonaPort;

    @GetMapping("/id/{id}")
    public PersonaOutputDTO getUsuarioByID(@PathVariable(value = "id") String id) {
        return readPersonaPort.getUsuarioByID(id);
    }

    @GetMapping("/all/all")
    public List<PersonaOutputDTO> getAllUsuarios() {
        return readPersonaPort.getAllUsuarios();
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaOutputDTO> getUsuarioByName(@PathVariable(value = "nombre") String nombre) {
        return readPersonaPort.getUsuarioByName(nombre);
    }
}
