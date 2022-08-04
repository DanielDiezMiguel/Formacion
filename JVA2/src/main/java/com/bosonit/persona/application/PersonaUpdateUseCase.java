package com.bosonit.persona.application;

import com.bosonit.persona.application.port.PersonaUpdatePort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.PersonaOutputDTO;
import com.bosonit.persona.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaUpdateUseCase implements PersonaUpdatePort {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO updatePersonaByID(Integer id, PersonaInputDTO personaInputDTO) throws Exception {
        PersonaEntity personaEntity = personaRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado a la Persona con ID: " + id));
        personaEntity.update(personaInputDTO);
        personaRepository.save(personaEntity);
        return new PersonaOutputDTO(personaEntity);
    }
}
