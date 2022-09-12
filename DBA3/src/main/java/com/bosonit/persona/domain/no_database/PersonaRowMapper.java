package com.bosonit.persona.domain.no_database;

import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaRowMapper implements RowMapper<PersonaOutputDTO> {
    @Override
    public PersonaOutputDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PersonaOutputDTO(new PersonaEntity(
                rs.getInt("id_persona"),
                rs.getString("usuario"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("surname")
        ));
    }
}
