package com.bosonit.persona.repository.jpa;

import com.bosonit.persona.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {
    List<PersonaEntity> findByUsuario(String usuario);
}
