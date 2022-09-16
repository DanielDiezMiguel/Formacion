package com.bosonit.Mapping.infrastructure.controller.dto.input;

import lombok.Data;

@Data
public class PersonaInputDTO {
  private Integer id;
  private String nombre;
  private String apellidos;
  private long edad;
}
