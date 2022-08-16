package com.bosonit.persona.application.port;

import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

public interface ReadPersonaPort {

    PersonaOutputDTO getPersonaByID(Integer id) throws Exception;

    List<PersonaOutputDTO> getAllPersonas();

}