package com.bosonit.Estudiante.infrastructure.controller.dto.input;

import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.Persona.domain.PersonaEntity;
import com.bosonit.Profesor.domain.ProfesorEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StudentInputDTO implements Serializable {

    private String id_student;
    private String id_persona;
    private int num_hours_week;
    private String comentarios;
    private String branch;
    private List<String> estudios;

}