package com.bosonit.Estudiante.application;

import com.bosonit.Estudiante.application.port.UpdateStudentPort;
import com.bosonit.Estudiante.domain.StudentEntity;
import com.bosonit.Estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import com.bosonit.Estudiante.infrastructure.repository.jpa.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentUseCase implements UpdateStudentPort {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentOutputDTO updateByID(StudentInputDTO studentInputDTO, String id) throws Exception {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> new Exception("No se ha podido actualizar con el ID: " + id));
        studentEntity.update(studentInputDTO);
        studentRepository.save(studentEntity);
        return new StudentOutputDTO(studentEntity);
    }
}
