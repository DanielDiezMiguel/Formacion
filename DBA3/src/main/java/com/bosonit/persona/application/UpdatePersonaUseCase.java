package com.bosonit.persona.application;

import com.bosonit.persona.application.port.UpdatePersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.exception.NotFoundException;
import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonaUseCase implements UpdatePersonaPort {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    JdbcOperations jdbcOperations;

    @Override
    public ResponseEntity updateByID(Integer id, PersonaInputDTO personaInputDTO) {

        PersonaEntity personaEntity = personaRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado a la Persona con ID: " + id));

        jdbcOperations.update("""
                        UPDATE Persona
                        SET usuario = ?, password = ?, name = ?, surname = ? 
                        WHERE id_persona = ? 
                        """,
                personaInputDTO.getUsuario(), personaInputDTO.getPassword(), personaInputDTO.getName(),
                personaInputDTO.getSurname(), personaInputDTO.getId_persona());

        return ResponseEntity.ok().build();
    }
}
