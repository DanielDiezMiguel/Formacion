package com.bosonit.estudiante.infrastructure.repository.jpa;

import com.bosonit.estudiante.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    List<StudentEntity> findByBranch(String branch);
}
