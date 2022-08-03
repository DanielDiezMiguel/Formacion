package com.bosonit.persona.infrastructure.controller.dto.output;

import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
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
