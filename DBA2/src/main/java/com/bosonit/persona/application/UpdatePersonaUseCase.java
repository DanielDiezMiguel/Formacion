package com.bosonit.persona.application;

import com.bosonit.persona.application.port.UpdatePersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.exception.NotFoundException;
import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.persona.infrastructure.repository.mongo.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


@Service
public class UpdatePersonaUseCase implements UpdatePersonaPort {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public PersonaOutputDTO updateUsuarioByID(String id, PersonaInputDTO personaInputDTO) {
        if (mongoTemplate.exists(Query.query(Criteria.where("id_persona").is(id)), PersonaEntity.class)) {
            PersonaEntity personaEntity = mongoTemplate.findById(id, PersonaEntity.class);
            personaEntity.update(personaInputDTO);
            mongoTemplate.save(personaEntity);
            return new PersonaOutputDTO(personaEntity);
        }

        throw new NotFoundException("No se ha encontrado a la Persona con ID: " + id);
    }
}
