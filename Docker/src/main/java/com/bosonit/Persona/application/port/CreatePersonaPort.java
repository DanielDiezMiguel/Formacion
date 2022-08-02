package com.bosonit.Persona.application.port;

import com.bosonit.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;

public interface CreatePersonaPort {
    public PersonaOutputDTO crearUsuario(PersonaInputDTO personaInputDTO);
}
