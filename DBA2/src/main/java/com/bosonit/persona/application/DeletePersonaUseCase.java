package com.bosonit.persona.application;

import com.bosonit.persona.application.port.DeletePersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.exception.NotFoundException;
import com.bosonit.persona.infrastructure.repository.mongo.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUseCase implements DeletePersonaPort {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void deleteByID(String id) {
        if (mongoTemplate.exists(Query.query(Criteria.where("id_persona").is(id)), PersonaEntity.class))
            mongoTemplate.remove(Query.query(Criteria.where("id_persona").is(id)), PersonaEntity.class);
        else throw new NotFoundException("No se ha encontrado la Persona con ID: " + id);
    }
}