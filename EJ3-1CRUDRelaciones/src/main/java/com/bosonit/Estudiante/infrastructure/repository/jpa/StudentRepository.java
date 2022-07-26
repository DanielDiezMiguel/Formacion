package com.bosonit.Estudiante.infrastructure.repository.jpa;

import com.bosonit.Estudiante.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
}
