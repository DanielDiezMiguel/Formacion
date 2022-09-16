package com.bosonit.Mapping.application.port;

import com.bosonit.Mapping.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

public interface PersonaReadPort {
    List<PersonaOutputDTO> getAll();
}
