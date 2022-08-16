package com.bosonit.persona.application;

import com.bosonit.persona.application.port.ReadPersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadPersonaUseCase implements ReadPersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO getPersonaByID(Integer id) throws Exception {
        PersonaEntity personaEntity = personaRepository.findById(String.valueOf(id)).orElseThrow(() -> new Exception("No se ha encontrado la Pesona con ID: " + id));
        return new PersonaOutputDTO(personaEntity);
    }

    @Override
    public List<PersonaOutputDTO> getAllPersonas() {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        personaRepository.findAll().forEach(personaEntity -> personaOutputDTOList.add(new PersonaOutputDTO(personaEntity)));
        return personaOutputDTOList;
    }

}