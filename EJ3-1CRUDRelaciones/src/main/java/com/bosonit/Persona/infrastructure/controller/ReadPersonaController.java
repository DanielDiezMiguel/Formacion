package com.bosonit.Persona.infrastructure.controller;

import com.bosonit.Persona.application.port.ReadPersonaPort;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
