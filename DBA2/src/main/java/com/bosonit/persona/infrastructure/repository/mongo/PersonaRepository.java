package com.bosonit.persona.infrastructure.repository.mongo;

import com.bosonit.persona.domain.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonaRepository extends MongoRepository<Persona, String> {
    List<Persona> findByName(String nombre);
}
