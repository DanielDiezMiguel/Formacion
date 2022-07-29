package com.bosonit.Estudiante.application;

import com.bosonit.Estudiante.application.port.CreateStudentPort;
import com.bosonit.Estudiante.domain.StudentEntity;
import com.bosonit.Estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import com.bosonit.Estudiante.infrastructure.repository.jpa.StudentRepository;
import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.EstudianteAsignatura.infrastructure.repository.jpa.EstudianteAsignaturaRespository;
import com.bosonit.Persona.domain.PersonaEntity;
import com.bosonit.Persona.infrastructure.repository.jpa.PersonaRepository;
import com.bosonit.Profesor.domain.ProfesorEntity;
import com.bosonit.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

        studentInputDTO.getEstudios().forEach(estudianteAsignaturaEntity -> {
            EstudianteAsignaturaEntity estudianteAsignaturaEntity1 = estudianteAsignaturaRespository.findById(estudianteAsignaturaEntity).orElseThrow();
            estudianteAsignaturaEntitiesList.add(estudianteAsignaturaEntity1);
        });

        studentEntity.setEstudios(estudianteAsignaturaEntitiesList);
        studentRepository.save(studentEntity);
        return new StudentOutputDTO(studentEntity);

    }

//    @Override
//    public StudentOutputDTO crearStudent(StudentInputDTO studentInputDTO) throws Exception {
//        PersonaEntity personaEntity = personaRepository.findById(studentInputDTO.getId_persona()).orElseThrow(() -> new Exception("No se ha encontrado el ID de Persona"));
//        ProfesorEntity profesorEntity = profesorRepository.findById(studentInputDTO.getId_profesor()).orElseThrow(() -> new Exception("No se ha encontrado el ID de Profesor"));
//        StudentEntity studentEntity = new StudentEntity(studentInputDTO);
//        studentEntity.setPersonaEntity(personaEntity);
//
//        // Comienza la comprobación de una persona no puede ser estudiante y profesor
//        studentEntity.setProfesorEntity(profesorEntity);
//        if (studentEntity.getProfesorEntity().getId_profesor() != null) {
//            if (!studentEntity.getPersonaEntity().getId_persona().equals(studentEntity.getProfesorEntity().getId_profesor())) {
//                studentRepository.save(studentEntity);
//                return new StudentOutputDTO(studentEntity);
//            }
//
//        } else {
//            studentRepository.save(studentEntity);
//            return new StudentOutputDTO(studentEntity);
//        }
//
//        return new StudentOutputDTO(new StudentEntity());
//    }
}
