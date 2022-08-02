package com.bosonit.Persona.application.port;

import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

public interface ReadPersonaPort {
    PersonaOutputDTO getPersonaByID(String id, String outputType) throws Exception;

    List getAllUsuarios(String outputType);

    List getPersonaByName(String name, String outputType);
}
