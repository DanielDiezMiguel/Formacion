package com.bosonit.Mapping.application.port;

import com.bosonit.Mapping.infrastructure.controller.dto.PersonaOutputDTO;

import java.util.List;

public interface PersonaReadPort {
    List<PersonaOutputDTO> getAll();
}
