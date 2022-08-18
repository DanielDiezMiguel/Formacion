package com.bosonit.estudiante.application;

import com.bosonit.estudiante.application.port.CreateStudentPort;
import com.bosonit.estudiante.domain.StudentEntity;
import com.bosonit.estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import com.bosonit.estudiante.infrastructure.repository.jpa.StudentRepository;
import com.bosonit.estudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.estudianteAsignatura.infrastructure.repository.jpa.EstudianteAsignaturaRespository;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateStudentUseCase implements CreateStudentPort {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    EstudianteAsignaturaRespository estudianteAsignaturaRespository;
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public StudentOutputDTO crearStudent(StudentInputDTO studentInputDTO) throws Exception {
        List<EstudianteAsignaturaEntity> estudianteAsignaturaEntitiesList = new ArrayList<>();
        PersonaEntity personaEntity = personaRepository.findById(studentInputDTO.getId_persona()).orElseThrow(() -> new Exception("No se ha encontrado el ID de Persona"));
        StudentEntity studentEntity = new StudentEntity(studentInputDTO);
        studentEntity.setPersonaEntity(personaEntity);

        studentInputDTO.getEstudios().forEach(estudios -> {
            EstudianteAsignaturaEntity estudianteAsignatura = estudianteAsignaturaRespository.findById(estudios).orElseThrow();
            estudianteAsignaturaEntitiesList.add(estudianteAsignatura);
        });

        studentEntity.setEstudios(estudianteAsignaturaEntitiesList);

        studentRepository.save(studentEntity);
        return new StudentOutputDTO(studentEntity);

    }
}
