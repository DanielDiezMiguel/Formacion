package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.ReadPersonaPort;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persona")
public class ReadPersonaController {

    @Autowired
    ReadPersonaPort readPersonaPort;

    @GetMapping("/id/{id}")
    public PersonaOutputDTO getPersonaByID(@PathVariable(name = "id") Integer id) throws Exception {
        return readPersonaPort.getPersonaByID(id);
    }

    @GetMapping("/all/all")
    public List<PersonaOutputDTO> getAllPersonas() {
        return readPersonaPort.getAllPersonas();
    }


}
