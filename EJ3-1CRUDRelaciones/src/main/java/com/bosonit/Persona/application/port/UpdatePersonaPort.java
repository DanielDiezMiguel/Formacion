package com.bosonit.Persona.application.port;

import com.bosonit.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface UpdatePersonaPort {

    public PersonaOutputDTO updateUsuarioByID(@PathVariable(value = "id") Integer id, PersonaInputDTO personaInputDTO);
}
