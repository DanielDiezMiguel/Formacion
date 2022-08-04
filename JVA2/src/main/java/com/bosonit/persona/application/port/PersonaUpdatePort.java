package com.bosonit.persona.application.port;

import com.bosonit.persona.infrastructure.controller.dto.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.PersonaOutputDTO;

public interface PersonaUpdatePort {
    PersonaOutputDTO updatePersonaByID(Integer id, PersonaInputDTO personaInputDTO) throws Exception;
}
