package com.bosonit.persona.infrastructure.controller.dto.output;

import com.bosonit.estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import com.bosonit.persona.domain.PersonaEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class PersonaStudentOutputDTO extends PersonaOutputDTO implements Serializable {

    StudentOutputDTO studentOutputDTO;

    public PersonaStudentOutputDTO(PersonaEntity personaEntity) {
        super(personaEntity);
        if (personaEntity == null) return;
        studentOutputDTO = new StudentOutputDTO(personaEntity.getStudentEntity());
    }
}
