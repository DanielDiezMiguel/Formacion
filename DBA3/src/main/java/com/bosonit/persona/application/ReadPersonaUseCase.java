package com.bosonit.persona.application;

import com.bosonit.persona.application.port.ReadPersonaPort;
import com.bosonit.persona.domain.no_database.PersonaRowMapper;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadPersonaUseCase implements ReadPersonaPort {

    @Autowired
    JdbcOperations jdbcOperations;

    @Override
    public List<PersonaOutputDTO> selectPersonas() {
        String sql = """
                SELECT id_persona, usuario, password, name, surname
                FROM Persona
                """;
        return jdbcOperations.query(sql, new PersonaRowMapper());
    }
}
