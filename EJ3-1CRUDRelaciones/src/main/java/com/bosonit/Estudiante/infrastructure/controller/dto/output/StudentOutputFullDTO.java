package com.bosonit.Estudiante.infrastructure.controller.dto.output;

import com.bosonit.Estudiante.domain.StudentEntity;
import com.bosonit.Estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.Persona.domain.PersonaEntity;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.Profesor.domain.ProfesorEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class StudentOutputFullDTO extends StudentOutputDTO implements Serializable {
   private PersonaOutputDTO personaOutputDTO;

    public StudentOutputFullDTO(StudentEntity studentEntity) {
        super(studentEntity);
        if (studentEntity == null) return;
        personaOutputDTO= new PersonaOutputDTO(studentEntity.getPersonaID());


    }
}
