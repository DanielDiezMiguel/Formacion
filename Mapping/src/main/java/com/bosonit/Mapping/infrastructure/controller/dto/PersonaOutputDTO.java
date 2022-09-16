package com.bosonit.Mapping.infrastructure.controller.dto;

import lombok.Data;

@Data
public class PersonaOutputDTO {
  private Integer id;
  private String nombre;
  private String apellidos;
  private long edad;
}
