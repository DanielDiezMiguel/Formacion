package com.bosonit.persona.application.port;

import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

public interface ReadPersonaPort {
    List<PersonaOutputDTO> getPersonaByID(String id);

    List<PersonaOutputDTO> getAllPersonas();

    List<PersonaOutputDTO> getPersonaByName(String name);
}
