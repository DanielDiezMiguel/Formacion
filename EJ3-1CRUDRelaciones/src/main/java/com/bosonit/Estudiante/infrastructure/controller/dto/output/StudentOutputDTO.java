package com.bosonit.Estudiante.infrastructure.controller.dto.output;

import com.bosonit.Estudiante.domain.StudentEntity;
import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.Profesor.domain.ProfesorEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StudentOutputDTO implements Serializable{
    private String id_student;
    private String id_persona;
    private int num_hours_week;
    private String comentarios;
    private String branch;
//    private List<EstudianteAsignaturaEntity> estudios;

    public StudentOutputDTO(StudentEntity studentEntity) {
        if (studentEntity == null) return;
        id_student = studentEntity.getId_student();
        id_persona = studentEntity.getPersonaEntity().getId_persona();
        num_hours_week = studentEntity.getNum_hours_week();
        comentarios = studentEntity.getComentarios();
        branch = studentEntity.getBranch();
//        estudios = studentEntity.getEstudios();

    }

}
