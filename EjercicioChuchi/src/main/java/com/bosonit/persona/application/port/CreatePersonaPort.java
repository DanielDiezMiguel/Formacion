package com.bosonit.persona.application.port;

import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;

import javax.validation.Valid;

public interface CreatePersonaPort {

    PersonaOutputDTO crearUsuario(PersonaInputDTO personaInputDTO, String idEstudiante);
}
