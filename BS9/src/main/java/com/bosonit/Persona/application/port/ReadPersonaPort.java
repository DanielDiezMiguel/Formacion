package com.bosonit.Persona.application.port;

import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReadPersonaPort {
    PersonaOutputDTO getPersonaByID(String id, String outputType) throws Exception;

    List getAllUsuarios(String outputType);

    List getPersonaByName(String name, String outputType);

    ProfesorOutputDTO getProfesor(String id) throws Exception;
}
