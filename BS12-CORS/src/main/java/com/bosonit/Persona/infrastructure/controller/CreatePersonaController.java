package com.bosonit.Persona.infrastructure.controller;

import com.bosonit.Persona.application.port.CreatePersonaPort;
import com.bosonit.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.POST)
@RequestMapping("persona")
public class CreatePersonaController {

    @Autowired
    CreatePersonaPort createPersonaPort;

    @PostMapping
    public PersonaOutputDTO crearUsuario(@RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        return createPersonaPort.crearUsuario(personaInputDTO);
    }
}


