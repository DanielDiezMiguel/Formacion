package com.bosonit.persona.application.port;

import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface UpdatePersonaPort {
    ResponseEntity updateByID(Integer id, PersonaInputDTO personaInputDTO);
}
