package com.bosonit.Profesor.infrastructure.repository.jpa;

import com.bosonit.Profesor.domain.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesorRepository extends JpaRepository<ProfesorEntity, String> {
    List<ProfesorEntity> findByBranch(String branch);
}
