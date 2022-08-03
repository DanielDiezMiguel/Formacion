package com.bosonit.estudiante.infrastructure.controller.dto.output;

import com.bosonit.estudiante.domain.StudentEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentOutputDTO implements Serializable{
    private String id_student;
    private String id_persona;
    private int num_hours_week;
    private String comentarios;
    private String branch;
    private List<String> estudios = new ArrayList<>();

    public StudentOutputDTO(StudentEntity studentEntity) {
        if (studentEntity == null) return;
        id_student = studentEntity.getId_student();
        id_persona = studentEntity.getPersonaEntity().getId_persona();
        num_hours_week = studentEntity.getNum_hours_week();
        comentarios = studentEntity.getComentarios();
        branch = studentEntity.getBranch();
        if (studentEntity.getEstudios() != null) {
            studentEntity.getEstudios().forEach(estudianteAsignaturaEntity -> {
                estudios.add(estudianteAsignaturaEntity.getId_asignatura());
            });
        }

    }

}