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

    @GetMapping("/id/{id}")
    public List<PersonaOutputDTO> getPersonaByID(@PathVariable(name = "id") String id) {
        return readPersonaPort.getPersonaByID(id);
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
