package com.bosonit.persona.application;

import com.bosonit.persona.application.port.PersonaReadPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.PersonaOutputDTO;
import com.bosonit.persona.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaReadUseCase implements PersonaReadPort {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO getPersonaByID(Integer id) throws Exception {
        PersonaEntity personaEntity = personaRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado la Persona con ID: " + id));
        return new PersonaOutputDTO(personaEntity);
    }

    @Override
    public List<PersonaOutputDTO> getAllPersonas() throws Exception {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        personaRepository.findAll().forEach(personaEntity -> personaOutputDTOList.add(new PersonaOutputDTO(personaEntity)));
        return personaOutputDTOList;
    }

    @Override
    public List<PersonaOutputDTO> getPersonaByUsuario(String usuario) throws Exception {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        personaRepository.findByUsuario(usuario).forEach(personaEntity -> personaOutputDTOList.add(new PersonaOutputDTO(personaEntity)));
        return personaOutputDTOList;
    }
}
