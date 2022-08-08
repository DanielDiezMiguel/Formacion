package com.bosonit.persona.application.port;

import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.util.HashMap;
import java.util.List;

public interface ReadPersonaPort {
    PersonaOutputDTO getPersonaByID(String id, String outputType) throws Exception;

    List getAllUsuarios(String outputType);

    List getPersonaByName(String name, String outputType);

    List<PersonaOutputDTO> getData(HashMap<String, Object> conditions);
}
