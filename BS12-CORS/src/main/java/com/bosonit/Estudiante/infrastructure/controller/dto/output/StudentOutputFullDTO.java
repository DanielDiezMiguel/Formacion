package com.bosonit.Estudiante.infrastructure.controller.dto.output;

import com.bosonit.Estudiante.domain.StudentEntity;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class StudentOutputFullDTO extends StudentOutputDTO implements Serializable {
   private PersonaOutputDTO personaOutputDTO;

    public StudentOutputFullDTO(StudentEntity studentEntity) {
        super(studentEntity);
        if (studentEntity == null) return;
        personaOutputDTO = new PersonaOutputDTO(studentEntity.getPersonaEntity());
    }
}
