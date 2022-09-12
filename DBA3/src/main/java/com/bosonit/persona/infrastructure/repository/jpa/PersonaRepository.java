package com.bosonit.persona.infrastructure.repository.jpa;

import com.bosonit.persona.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {
    List<PersonaEntity> findByName(String nombre);
}
