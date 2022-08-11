package com.bosonit.persona.application;

import com.bosonit.persona.application.port.ReadPersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.persona.infrastructure.repository.mongo.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadPersonaUseCase implements ReadPersonaPort {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<PersonaOutputDTO> getPersonaByID(String id) {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        Query query = new Query();
        query.addCriteria(Criteria.where("id_persona").is(id));
        mongoTemplate.find(query, PersonaEntity.class).forEach(persona -> personaOutputDTOList.add(new PersonaOutputDTO(persona)));
        return personaOutputDTOList;
    }

    @Override
    public List<PersonaOutputDTO> getAllPersonas() {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        mongoTemplate.findAll(PersonaEntity.class).forEach(persona -> personaOutputDTOList.add(new PersonaOutputDTO(persona)));
        return personaOutputDTOList;
    }
    @Override
    public List<PersonaOutputDTO> getPersonaByName(String name) {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        mongoTemplate.find(query, PersonaEntity.class).forEach(persona -> personaOutputDTOList.add(new PersonaOutputDTO(persona)));
        return personaOutputDTOList;
    }

}