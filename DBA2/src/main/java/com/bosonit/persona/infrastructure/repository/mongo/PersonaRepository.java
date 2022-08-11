package com.bosonit.persona.infrastructure.repository.mongo;

import com.bosonit.persona.domain.PersonaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonaRepository extends MongoRepository<PersonaEntity, String> {
    List<PersonaEntity> findByName(String nombre);
}
