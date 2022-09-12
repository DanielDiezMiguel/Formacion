package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.UpdatePersonaPort;
import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persona")
public class UpdatePersonaController {

    @Autowired
    UpdatePersonaPort updatePersonaPort;

    @PutMapping("/id/{id}")
    public PersonaOutputDTO updateUsuarioByID(
            @PathVariable(value = "id") String id, @RequestBody PersonaInputDTO personaInputDTO) {
        return updatePersonaPort.updateUsuarioByID(id, personaInputDTO);
    }
}