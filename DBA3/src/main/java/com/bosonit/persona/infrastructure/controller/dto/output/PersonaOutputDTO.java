package com.bosonit.persona.infrastructure.controller.dto.output;

import com.bosonit.persona.domain.PersonaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class PersonaOutputDTO {
    private Integer id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;

    public PersonaOutputDTO(PersonaEntity personaEntity) {
        if (personaEntity == null) return;
        id_persona = personaEntity.getId_persona();
        usuario = personaEntity.getUsuario();
        password = personaEntity.getPassword();
        name = personaEntity.getName();
        surname = personaEntity.getSurname();
    }

}
