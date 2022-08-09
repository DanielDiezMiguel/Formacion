package com.bosonit.persona.infrastructure.repository.jpa;

import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, String> {
    List<PersonaEntity> findByName(String nombre);
}