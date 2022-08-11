package com.bosonit.persona.application;

import com.bosonit.persona.application.port.DeletePersonaPort;
import com.bosonit.persona.domain.Persona;
import com.bosonit.persona.exception.NotFoundException;
import com.bosonit.persona.infrastructure.repository.mongo.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUseCase implements DeletePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    public void deleteByID(Integer id) {
        Persona persona = personaRepository.findById(String.valueOf(id)).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID"));
        personaRepository.delete(persona);
    }
}
