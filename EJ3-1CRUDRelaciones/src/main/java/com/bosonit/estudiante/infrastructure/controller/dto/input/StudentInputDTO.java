package com.bosonit.estudiante.infrastructure.controller.dto.input;

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