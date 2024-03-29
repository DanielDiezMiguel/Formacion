package com.bosonit.persona.application;

import com.bosonit.persona.application.port.DeletePersonaPort;
import com.bosonit.persona.exception.NotFoundException;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUseCase implements DeletePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    public void deleteByID(String id) {
        personaRepository.delete(personaRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado el ID")));
    }
}
