package com.bosonit.persona.application;

import com.bosonit.persona.application.port.DeletePersonaPort;
import com.bosonit.persona.exception.NotFoundException;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUseCase implements DeletePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    JdbcOperations jdbcOperations;

//    public void deleteByID(String id) {
//        PersonaEntity personaEntity = personaRepository
//                .findById(Integer.valueOf(id))
//                .orElseThrow(() -> new NotFoundException("No se ha encontrado el ID"));
//        personaRepository.delete(personaEntity);
//    }

    @Override
    public ResponseEntity deleteByID(Integer id) {
        personaRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado a la Persona con ID: " + id));

        jdbcOperations.update("""
                DELETE 
                FROM Persona
                WHERE id_persona = ?
                """, id);

        return ResponseEntity.ok().build();
    }
}
