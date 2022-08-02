package com.bosonit.Estudiante.infrastructure.controller.dto.output;

import com.bosonit.Estudiante.domain.StudentEntity;
import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.Profesor.domain.ProfesorEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class StudentOutputSimpleDTO extends StudentOutputDTO implements Serializable {
    public StudentOutputSimpleDTO(StudentEntity studentEntity) {
        super(studentEntity);
        if (studentEntity == null) return;
    }

}
