package com.bosonit.estudiante.application;

import com.bosonit.estudiante.application.port.UpdateStudentPort;
import com.bosonit.estudiante.domain.StudentEntity;
import com.bosonit.estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import com.bosonit.estudiante.infrastructure.repository.jpa.StudentRepository;
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
