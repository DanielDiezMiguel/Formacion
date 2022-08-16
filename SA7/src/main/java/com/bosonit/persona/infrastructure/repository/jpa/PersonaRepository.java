package com.bosonit.persona.infrastructure.repository.jpa;

import com.bosonit.persona.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<PersonaEntity, String> {
    List<PersonaEntity> findByName(String nombre);
}
