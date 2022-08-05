package com.bosonit.estudianteAsignatura.application;

import com.bosonit.estudiante.domain.StudentEntity;
import com.bosonit.estudiante.infrastructure.repository.jpa.StudentRepository;
import com.bosonit.estudianteAsignatura.application.port.CreateEstudianteAsignaturaPort;
import com.bosonit.estudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.estudianteAsignatura.infrastructure.controller.dto.input.EstudianteAsignaturaInputDTO;
import com.bosonit.estudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;
import com.bosonit.estudianteAsignatura.infrastructure.repository.jpa.EstudianteAsignaturaRespository;
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
