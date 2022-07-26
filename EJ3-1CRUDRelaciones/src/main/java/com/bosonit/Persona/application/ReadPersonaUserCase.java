package com.bosonit.Persona.application;

import com.bosonit.Persona.application.port.ReadPersonaPort;
import com.bosonit.Persona.domain.PersonaEntity;
import com.bosonit.Persona.exception.NotFoundException;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.Persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadPersonaUserCase implements ReadPersonaPort {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO getUsuarioByID(Integer id) {
        PersonaEntity personaEntity = personaRepository.findById(String.valueOf(id)).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID"));
        return new PersonaOutputDTO(personaEntity);

    }

    @Override
    public List<PersonaOutputDTO> getAllUsuarios() {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        if (personaRepository.findAll() != null) {
            personaRepository.findAll().forEach(persona -> {
                PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
                personaOutputDTOList.add(personaOutputDTO);
            });
            return personaOutputDTOList;

        }
        List<PersonaOutputDTO> personaOutputDTOListVacia = new ArrayList<>();
        return personaOutputDTOListVacia;

    }

    @Override
    public List<PersonaOutputDTO> getUsuarioByName(String name) {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        if (personaRepository.findByName(name) != null) {
            personaRepository.findByName(name).forEach(persona -> {
                PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
                personaOutputDTOList.add(personaOutputDTO);
            });
            return personaOutputDTOList;
        }
        List<PersonaOutputDTO> personaOutputDTOListVacia = new ArrayList<>();
        return personaOutputDTOListVacia;
    }

}
