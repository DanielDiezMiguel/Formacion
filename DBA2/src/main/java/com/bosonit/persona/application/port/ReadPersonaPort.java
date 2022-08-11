package com.bosonit.persona.application.port;

import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

public interface ReadPersonaPort {
    PersonaOutputDTO getPersonaByID(Integer id);

    List<PersonaOutputDTO> getAllPersonas();

    List<PersonaOutputDTO> getPersonaByName(String name);
}
