package com.bosonit.persona.application.port;

import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;

public interface CreatePersonaPort {
    PersonaOutputDTO crearUsuario(PersonaInputDTO personaInputDTO);
}