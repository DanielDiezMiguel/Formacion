package com.bosonit.Persona.infrastructure.controller.dto.output;

import com.bosonit.Persona.domain.PersonaEntity;
import com.bosonit.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class PersonaProfesorOutputDTO extends PersonaOutputDTO implements Serializable {

    private ProfesorOutputDTO profesorOutputDTO;

    public PersonaProfesorOutputDTO(PersonaEntity personaEntity) {
        super(personaEntity);
        if (personaEntity == null) return;
        profesorOutputDTO = new ProfesorOutputDTO(personaEntity.getProfesorEntity());
    }
}
