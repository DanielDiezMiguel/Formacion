package com.bosonit.persona.application;

import com.bosonit.persona.application.port.CreatePersonaPort;
import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonaUseCase implements CreatePersonaPort {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public ResponseEntity createUser(PersonaInputDTO personaInputDTO) {
        jdbcOperations.update("""
                        INSERT INTO Persona(id_persona, usuario, password, name, surname)
                        VALUES(?, ?, ?, ?, ?)
                        """,
                personaInputDTO.getId_persona(), personaInputDTO.getUsuario(),
                personaInputDTO.getPassword(), personaInputDTO.getName(), personaInputDTO.getSurname());

        return ResponseEntity.ok().build();
    }
}
