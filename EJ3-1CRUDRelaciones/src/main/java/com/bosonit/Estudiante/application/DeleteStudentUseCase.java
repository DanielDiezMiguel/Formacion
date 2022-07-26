package com.bosonit.Estudiante.application;

import com.bosonit.Estudiante.application.port.DeleteStudentPort;
import com.bosonit.Estudiante.domain.StudentEntity;
import com.bosonit.Estudiante.infrastructure.repository.jpa.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentUseCase implements DeleteStudentPort {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void deleteByID(String id) throws Exception {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> new Exception("No se ha podido borrar el Estudiante con ID: " + id));
        studentRepository.deleteById(id);
        studentRepository.save(studentEntity);
    }
}
