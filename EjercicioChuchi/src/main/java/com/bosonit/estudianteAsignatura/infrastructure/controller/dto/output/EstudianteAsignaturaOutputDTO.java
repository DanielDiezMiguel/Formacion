package com.bosonit.estudianteAsignatura.infrastructure.controller.dto.output;

import com.bosonit.estudianteAsignatura.domain.EstudianteAsignaturaEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EstudianteAsignaturaOutputDTO implements Serializable {
    private String id_asignatura;
    private String id_student;
    private String asignatura;
    private String comment;
    private Date initial_date;
    private Date finish_date;

    public EstudianteAsignaturaOutputDTO(EstudianteAsignaturaEntity estudianteAsignaturaEntity) {
        if (estudianteAsignaturaEntity == null) return;
        id_asignatura = estudianteAsignaturaEntity.getId_asignatura();
        id_student = estudianteAsignaturaEntity.getStudentEntity().getId_student();
        asignatura = estudianteAsignaturaEntity.getAsignatura();
        comment = estudianteAsignaturaEntity.getComment();
        initial_date = estudianteAsignaturaEntity.getInitial_date();
        finish_date = estudianteAsignaturaEntity.getFinish_date();
    }
}
