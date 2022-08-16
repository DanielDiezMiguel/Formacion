package com.bosonit.persona.application.port;

import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;

public interface UpdatePersonaPort {
    PersonaOutputDTO updateUsuarioByID(Integer id, PersonaInputDTO personaInputDTO) throws Exception;
}