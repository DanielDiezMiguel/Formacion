package com.bosonit.Persona.infrastructure.controller;

import com.bosonit.Persona.application.port.CreatePersonaPort;
import com.bosonit.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persona")
public class CreatePersonaController {

    @Autowired
    CreatePersonaPort createPersonaPort;

    @PostMapping
    @Operation(summary = "Crear Persona")
    public PersonaOutputDTO crearUsuario(@RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        return createPersonaPort.crearUsuario(personaInputDTO);
    }
}


