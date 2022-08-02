package com.bosonit.EstudianteAsignatura.application;

import com.bosonit.Estudiante.domain.StudentEntity;
import com.bosonit.Estudiante.infrastructure.repository.jpa.StudentRepository;
import com.bosonit.EstudianteAsignatura.application.port.CreateEstudianteAsignaturaPort;
import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.input.EstudianteAsignaturaInputDTO;
import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;
import com.bosonit.EstudianteAsignatura.infrastructure.repository.jpa.EstudianteAsignaturaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateEstudianteAsignaturaUseCase implements CreateEstudianteAsignaturaPort {

    @Autowired
    EstudianteAsignaturaRespository estudianteAsignaturaRespository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public EstudianteAsignaturaOutputDTO crearEstudianteAsignatura(EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) throws Exception{
        StudentEntity studentEntity = studentRepository.findById(estudianteAsignaturaInputDTO.getId_student()).orElseThrow(() -> new Exception("No se ha encontrado el ID"));
        EstudianteAsignaturaEntity estudianteAsignaturaEntity = new EstudianteAsignaturaEntity(estudianteAsignaturaInputDTO);
        estudianteAsignaturaEntity.setStudentEntity(studentEntity);
        estudianteAsignaturaRespository.save(estudianteAsignaturaEntity);
        return new EstudianteAsignaturaOutputDTO(estudianteAsignaturaEntity);

    }
}
