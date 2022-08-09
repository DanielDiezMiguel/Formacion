package com.bosonit.profesor.infrastructure.controller.dto.input;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProfesorInputDTO implements Serializable {
    private String id_profesor;
    private String id_persona;
    private String comentarios;
    private String branch;

}
