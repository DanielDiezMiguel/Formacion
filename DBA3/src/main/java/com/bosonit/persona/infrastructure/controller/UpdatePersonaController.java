package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.UpdatePersonaPort;
import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persona")
public class UpdatePersonaController {

    @Autowired
    UpdatePersonaPort updatePersonaPort;

    @PutMapping("/id")
    public ResponseEntity updateByID(
            @RequestParam(value = "id") Integer id,
            @RequestBody PersonaInputDTO personaInputDTO) {
        return updatePersonaPort.updateByID(id, personaInputDTO);
    }
}