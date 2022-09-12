package com.bosonit.persona.application.port;

import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.http.ResponseEntity;

public interface CreatePersonaPort {
    ResponseEntity createUser(PersonaInputDTO personaInputDTO);
}
