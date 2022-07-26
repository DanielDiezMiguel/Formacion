package com.bosonit.Persona.infrastructure.controller;

import com.bosonit.Persona.application.port.UpdatePersonaPort;
import com.bosonit.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdatePersonaController {

    @Autowired
    UpdatePersonaPort updatePersonaPort;

    @PutMapping("/usuario/update/{id}")
    public PersonaOutputDTO updateUsuarioByID(@PathVariable(value = "id") Integer id, @RequestBody PersonaInputDTO personaInputDTO) {
        return updatePersonaPort.updateUsuarioByID(id, personaInputDTO);
    }
}
