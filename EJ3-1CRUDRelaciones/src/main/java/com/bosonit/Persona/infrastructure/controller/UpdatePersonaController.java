package com.bosonit.Persona.infrastructure.controller;

import com.bosonit.Persona.application.port.UpdatePersonaPort;
import com.bosonit.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persona")
public class UpdatePersonaController {

    @Autowired
    UpdatePersonaPort updatePersonaPort;

    @PutMapping("{id}")
    public PersonaOutputDTO updateUsuarioByID(@PathVariable(value = "id") String id, @RequestBody PersonaInputDTO personaInputDTO) {
        return updatePersonaPort.updateUsuarioByID(id, personaInputDTO);
    }
}
