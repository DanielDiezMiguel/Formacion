package com.bosonit.persona.application.port;

import com.bosonit.persona.infrastructure.controller.dto.PersonaOutputDTO;

import java.util.List;

public interface PersonaReadPort {
    PersonaOutputDTO getPersonaByID(Integer id) throws Exception;

    List<PersonaOutputDTO> getAllPersonas() throws Exception;

    List<PersonaOutputDTO> getPersonaByUsuario(String usuario) throws Exception;

}