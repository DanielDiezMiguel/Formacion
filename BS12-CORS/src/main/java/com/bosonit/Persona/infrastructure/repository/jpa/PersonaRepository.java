package com.bosonit.Persona.infrastructure.repository.jpa;

import com.bosonit.Persona.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<PersonaEntity, String> {
    List<PersonaEntity> findByName(String nombre);
}
