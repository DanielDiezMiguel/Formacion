package com.bosonit.estudianteAsignatura.infrastructure.controller.dto.input;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EstudianteAsignaturaInputDTO implements Serializable {
    private String id_asignatura;
    private String id_student;
    private String asignatura;
    private String comment;
    private Date initial_date;
    private Date finish_date;
}
