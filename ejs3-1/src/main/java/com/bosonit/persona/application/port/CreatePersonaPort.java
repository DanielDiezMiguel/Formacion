package com.bosonit.persona.application.port;

import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;

public interface CreatePersonaPort {
    public PersonaOutputDTO crearUsuario(PersonaInputDTO personaInputDTO);
}
