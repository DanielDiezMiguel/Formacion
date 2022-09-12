package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.CreatePersonaPort;
import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.POST)
@RequestMapping("persona")
public class CreatePersonaController {

    @Autowired
    CreatePersonaPort createPersonaPort;

    @PostMapping
    public ResponseEntity<Integer> crearUsuario(@RequestBody PersonaInputDTO personaInputDTO) {
        return createPersonaPort.createUser(personaInputDTO);
    }
}


