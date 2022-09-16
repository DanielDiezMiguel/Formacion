package com.bosonit.Mapping.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class PersonaEntity {
    @Id private Integer id;
    private String nombre;
    private String apellidos;
    private long edad;
}
