package com.bosonit.Mapping.application.port;

import com.bosonit.Mapping.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.Mapping.infrastructure.controller.dto.output.PersonaOutputDTO;

public interface PersonaCreatePort {
    PersonaOutputDTO crearPersona(PersonaInputDTO personaInputDTO);
}
