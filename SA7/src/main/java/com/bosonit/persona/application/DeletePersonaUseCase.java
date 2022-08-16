package com.bosonit.persona.application;

import com.bosonit.persona.application.port.DeletePersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUseCase implements DeletePersonaPort {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public void deleteByID(Integer id) throws Exception {
        PersonaEntity personaEntity = personaRepository.findById(String.valueOf(id)).orElseThrow(() -> new Exception("No se ha encontrado el ID: " + id));
        personaRepository.delete(personaEntity);
    }
}