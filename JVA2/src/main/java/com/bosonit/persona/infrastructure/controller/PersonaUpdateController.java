package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.PersonaUpdatePort;
import com.bosonit.persona.infrastructure.controller.dto.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persona")
public class PersonaUpdateController {

    @Autowired
    PersonaUpdatePort personaUpdatePort;

    @PutMapping("{id}")
    public PersonaOutputDTO updatePersonaByID(@PathVariable(name = "id") Integer id, @RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        return personaUpdatePort.updatePersonaByID(id, personaInputDTO);
    }
}
