package com.bosonit.persona.application.port;

import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import org.springframework.http.ResponseEntity;

public interface CreatePersonaPort {
//    public PersonaOutputDTO crearUsuario(PersonaInputDTO personaInputDTO);

//    PersonaOutputDTO crearUsuario(PersonaInputDTO personaInputDTO, ResultSet resultSet) throws SQLException;

//    int createUser(PersonaInputDTO personaInputDTO, PersonaEntity personaEntity);

    ResponseEntity<Integer> createUser(PersonaInputDTO personaInputDTO);
}
