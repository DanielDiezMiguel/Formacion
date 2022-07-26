package com.bosonit.Estudiante.infrastructure.controller.dto.output;

import com.bosonit.Estudiante.domain.StudentEntity;
import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.Persona.domain.PersonaEntity;
import com.bosonit.Profesor.domain.ProfesorEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class StudentOutputDTO implements Serializable{
    private String id_student;
    private String personaID;
    private int num_hours_week;
    private String comentarios;
    private ProfesorEntity id_profesor;
    private String branch;
    private List<EstudianteAsignaturaEntity> estudios;

    public StudentOutputDTO(StudentEntity studentEntity) {
        if (studentEntity == null) return;
        id_student = studentEntity.getId_student();
        personaID = studentEntity.getPersonaID().getId_persona();
        num_hours_week = studentEntity.getNum_hours_week();
        comentarios = studentEntity.getComentarios();
        id_profesor = studentEntity.getProfesorEntity();
        branch = studentEntity.getBranch();
        estudios = studentEntity.getEstudios();

    }


//    public StudentOutputDTO() {
//        StudentEntity studentEntity = new StudentEntity();
//        id_student = studentEntity.getId_student();
//        personaID = studentEntity.getId_student();
//        num_hours_week = studentEntity.getNum_hours_week();
//        comentarios = studentEntity.getComentarios();
//        id_profesor = studentEntity.getProfesorEntity();
//        branch = studentEntity.getBranch();
//        estudios = studentEntity.getEstudios();
//    }

//    public StudentOutputDTO(StudentOutputSimpleDTO studentOutputSimpleDTO) {
//        if (studentOutputSimpleDTO == null) return;
//        id_student = studentOutputSimpleDTO.getId_student();
//        personaID = studentOutputSimpleDTO.getPersonaID();
//        num_hours_week = studentOutputSimpleDTO.getNum_hours_week();
//        comentarios = studentOutputSimpleDTO.getComentarios();
//        id_profesor = studentOutputSimpleDTO.getId_profesor();
//        branch = studentOutputSimpleDTO.getBranch();
//        estudios = studentOutputSimpleDTO.getEstudios();
//
//    }

//    public StudentOutputDTO(StudentOutputFullDTO studentOutputFullDTO) {
//        if (studentOutputFullDTO == null) return;
//        id_student = studentOutputFullDTO.getId_student();
//        personaID = studentOutputFullDTO.getPersonaID();
//        num_hours_week = studentOutputFullDTO.getNum_hours_week();
//        comentarios = studentOutputFullDTO.getComentarios();
//        id_profesor = studentOutputFullDTO.getId_profesor();
//        branch = studentOutputFullDTO.getBranch();
//        estudios = studentOutputFullDTO.getEstudios();
//    }

}
