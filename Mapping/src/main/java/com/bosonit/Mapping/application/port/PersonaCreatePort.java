package com.bosonit.Mapping.application.port;

import com.bosonit.Mapping.infrastructure.controller.dto.PersonaInputDTO;
import com.bosonit.Mapping.infrastructure.controller.dto.PersonaOutputDTO;

public interface PersonaCreatePort {
    PersonaOutputDTO crearPersona(PersonaInputDTO personaInputDTO);
}
