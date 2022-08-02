package com.bosonit.Persona.infrastructure.controller.dto.output;

import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import com.bosonit.Persona.domain.PersonaEntity;
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
