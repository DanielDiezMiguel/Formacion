package com.bosonit.persona.application;

import com.bosonit.persona.application.port.PersonaDeletePort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaDeleteUseCase implements PersonaDeletePort {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public void deleteByID(Integer id) throws Exception {
        PersonaEntity personaEntity = personaRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado la Persona con ID: " + id));
        personaRepository.deleteById(id);
    }
}
