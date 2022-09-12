package com.bosonit.persona.infrastructure.controller.dto.input;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonaInputDTO {
    private Integer id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
}
