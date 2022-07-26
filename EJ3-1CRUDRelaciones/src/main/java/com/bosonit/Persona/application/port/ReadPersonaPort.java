package com.bosonit.Persona.application.port;

import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

public interface ReadPersonaPort {
    PersonaOutputDTO getUsuarioByID(Integer id);
    List<PersonaOutputDTO> getAllUsuarios();
    List<PersonaOutputDTO> getUsuarioByName(String name);
}
