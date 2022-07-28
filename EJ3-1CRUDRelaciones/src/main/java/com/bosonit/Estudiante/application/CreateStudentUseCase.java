package com.bosonit.Estudiante.application;

import com.bosonit.Estudiante.application.port.CreateStudentPort;
import com.bosonit.Estudiante.domain.StudentEntity;
import com.bosonit.Estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import com.bosonit.Estudiante.infrastructure.repository.jpa.StudentRepository;
import com.bosonit.Persona.domain.PersonaEntity;
import com.bosonit.Persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentUseCase implements CreateStudentPort {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public StudentOutputDTO crearStudent(StudentInputDTO studentInputDTO) throws Exception {
        PersonaEntity personaEntity = personaRepository.findById(studentInputDTO.getId_persona()).orElseThrow(() -> new Exception("No se ha encontrado el ID de Persona"));
        StudentEntity studentEntity = new StudentEntity(studentInputDTO);
        studentEntity.setPersonaEntity(personaEntity);
        studentRepository.save(studentEntity);
        return new StudentOutputDTO(studentEntity);

    }
}
