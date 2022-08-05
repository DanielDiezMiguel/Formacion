package com.bosonit.estudianteAsignatura.infrastructure.controller.dto.output;

import com.bosonit.estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import com.bosonit.estudianteAsignatura.domain.EstudianteAsignaturaEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class EstudianteSoloAsignaturaOutputDTO extends EstudianteAsignaturaOutputDTO implements Serializable {

    private StudentOutputDTO studentOutputDTO;

    public EstudianteSoloAsignaturaOutputDTO(EstudianteAsignaturaEntity estudianteAsignaturaEntity) {
        super(estudianteAsignaturaEntity);
        if (estudianteAsignaturaEntity == null) return;
        studentOutputDTO = new StudentOutputDTO(estudianteAsignaturaEntity.getStudentEntity());
    }
}
