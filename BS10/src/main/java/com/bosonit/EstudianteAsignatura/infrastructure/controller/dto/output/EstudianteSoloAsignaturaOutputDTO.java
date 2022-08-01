package com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.output;

import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
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
