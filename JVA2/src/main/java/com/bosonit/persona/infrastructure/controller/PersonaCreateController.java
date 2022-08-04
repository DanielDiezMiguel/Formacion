package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.PersonaCreatePort;
import com.bosonit.persona.infrastructure.controller.dto.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class PersonaCreateController {

    @Autowired
    PersonaCreatePort personaCreatePort;

    @PostMapping
    public PersonaOutputDTO crearPersona(@RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        return personaCreatePort.crearPersona(personaInputDTO);
    }
}
