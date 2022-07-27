package com.bosonit.Persona.application;

import com.bosonit.Persona.application.port.DeletePersonaPort;
import com.bosonit.Persona.domain.PersonaEntity;
import com.bosonit.Persona.exception.NotFoundException;
import com.bosonit.Persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUserCase implements DeletePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    public void deleteByID(String id) {
        PersonaEntity personaEntity = personaRepository.findById(String.valueOf(id)).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID"));
        personaRepository.delete(personaEntity);
        personaRepository.save(personaEntity);
    }
}
