package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.ReadPersonaPort;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
@RequestMapping("persona")
public class ReadPersonaController {

    @Autowired
    ReadPersonaPort readPersonaPort;

    @GetMapping("/id/{id_persona}")
    public List<PersonaOutputDTO> getPersonaByID(@PathVariable(name = "id_persona") String id_persona) {
        return readPersonaPort.getPersonaByID(id_persona);
    }

    @GetMapping("/all/all")
    public List<PersonaOutputDTO> getAllPersonas() {
        return readPersonaPort.getAllPersonas();
    }

    @GetMapping("/name/{name}")
    public List<PersonaOutputDTO> getPersonaByName(@PathVariable("name") String name) {
        return readPersonaPort.getPersonaByName(name);
    }

}
