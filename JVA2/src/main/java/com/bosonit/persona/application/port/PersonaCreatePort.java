package com.bosonit.persona.application.port;

import com.bosonit.persona.infrastructure.controller.dto.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.PersonaOutputDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface PersonaCreatePort {
    PersonaOutputDTO crearPersona(@RequestBody PersonaInputDTO personaInputDTO) throws Exception;

    }
