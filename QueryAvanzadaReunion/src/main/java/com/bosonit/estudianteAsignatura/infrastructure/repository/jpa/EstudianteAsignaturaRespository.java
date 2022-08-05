package com.bosonit.estudianteAsignatura.infrastructure.repository.jpa;

import com.bosonit.estudianteAsignatura.domain.EstudianteAsignaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteAsignaturaRespository extends JpaRepository<EstudianteAsignaturaEntity, String> {

}
