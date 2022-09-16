package com.bosonit.Mapping.infrastructure.repository.jpa;

import com.bosonit.Mapping.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
