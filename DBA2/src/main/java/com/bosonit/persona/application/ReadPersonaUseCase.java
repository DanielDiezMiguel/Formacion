package com.bosonit.persona.application;

import com.bosonit.persona.application.port.ReadPersonaPort;
import com.bosonit.persona.domain.Persona;
import com.bosonit.persona.exception.NotFoundException;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.persona.infrastructure.repository.mongo.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadPersonaUseCase implements ReadPersonaPort {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO getPersonaByID(Integer id) {
        Persona persona = personaRepository.findById(String.valueOf(id)).orElseThrow(() -> new NotFoundException("No se ha encontrado la Persona con ID: " + id));
        return new PersonaOutputDTO(persona);
    }
    @Override
    public List<PersonaOutputDTO> getAllPersonas() {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        personaRepository.findAll().forEach(persona -> personaOutputDTOList.add(new PersonaOutputDTO(persona)));
        return personaOutputDTOList;
    }
    @Override
    public List<PersonaOutputDTO> getPersonaByName(String name) {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        personaRepository.findByName(name).forEach(persona -> personaOutputDTOList.add(new PersonaOutputDTO(persona)));
        return personaOutputDTOList;
    }

}
