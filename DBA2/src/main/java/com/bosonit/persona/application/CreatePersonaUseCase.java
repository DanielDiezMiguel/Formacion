package com.bosonit.persona.application;

import com.bosonit.persona.application.port.CreatePersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


@Service
public class CreatePersonaUseCase implements CreatePersonaPort {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public PersonaOutputDTO crearUsuario(PersonaInputDTO personaInputDTO) {
        PersonaEntity personaEntity = new PersonaEntity(personaInputDTO);
        mongoTemplate.save(personaEntity);
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaEntity);
        return personaOutputDTO;

    }
}
