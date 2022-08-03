package com.bosonit.estudiante.infrastructure.controller.dto.output;

import com.bosonit.estudiante.domain.StudentEntity;
import com.bosonit.Profesor.domain.ProfesorEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class StudentOutputSimpleDTO extends StudentOutputDTO implements Serializable {
    public StudentOutputSimpleDTO(StudentEntity studentEntity) {
        super(studentEntity);
        if (studentEntity == null) return;
    }

}
