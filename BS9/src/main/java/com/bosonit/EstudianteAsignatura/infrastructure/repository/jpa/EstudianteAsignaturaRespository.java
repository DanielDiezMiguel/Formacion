package com.bosonit.EstudianteAsignatura.infrastructure.repository.jpa;

import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteAsignaturaRespository extends JpaRepository<EstudianteAsignaturaEntity, String> {

}
