package com.bosonit.persona.application;

import com.bosonit.estudiante.domain.StudentEntity;
import com.bosonit.estudiante.infrastructure.repository.jpa.StudentRepository;
import com.bosonit.persona.application.port.CreatePersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.exception.UnprocesableException;
import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonaUseCase implements CreatePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public PersonaOutputDTO crearUsuario(PersonaInputDTO personaInputDTO, String idEstudiante) {
        try {
            PersonaEntity personaEntity = new PersonaEntity(personaInputDTO);
            personaRepository.save(personaEntity);

            StudentEntity studentEntity = studentRepository.findById(idEstudiante).orElse(new StudentEntity());
            System.out.println("ID: ---------------------> " + studentEntity.getId_student());
            personaEntity.setStudentEntity(studentEntity);

            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaEntity);
            return personaOutputDTO;

        } catch (Exception e) {
            throw new UnprocesableException("No cumple los requisitos establecidos");
        }

    }
}