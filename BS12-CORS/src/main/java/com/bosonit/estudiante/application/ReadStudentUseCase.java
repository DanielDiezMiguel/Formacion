package com.bosonit.estudiante.application;

import com.bosonit.estudiante.application.port.ReadStudentPort;
import com.bosonit.estudiante.domain.StudentEntity;
import com.bosonit.estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import com.bosonit.estudiante.infrastructure.controller.dto.output.StudentOutputFullDTO;
import com.bosonit.estudiante.infrastructure.controller.dto.output.StudentOutputSimpleDTO;
import com.bosonit.estudiante.infrastructure.repository.jpa.StudentRepository;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadStudentUseCase implements ReadStudentPort {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public StudentOutputDTO getStudentByID(String id, String outType) throws Exception {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado el ID de Estudiante"));
        if (outType.equalsIgnoreCase("simple"))
            return new StudentOutputSimpleDTO(studentEntity);
        else
            return new StudentOutputFullDTO(studentEntity);
    }


    @Override
    public List<StudentOutputDTO> getAllStudents() {
        if (studentRepository.findAll() != null) {
            List<StudentOutputDTO> studentOutputDTOList = new ArrayList<>();
            studentRepository.findAll().forEach(studentEntity -> {
                StudentOutputDTO studentOutputDTO = new StudentOutputDTO(studentEntity);
                studentOutputDTOList.add(studentOutputDTO);
            });
            return studentOutputDTOList;
        }

        List<StudentOutputDTO> studentOutputDTOListVacia = new ArrayList<>();
        return studentOutputDTOListVacia;
    }

    @Override
    public List<StudentOutputDTO> getStudentByBranch(String branch) {
        if (studentRepository.findAll() != null) {
            List<StudentOutputDTO> studentOutputDTOList = new ArrayList<>();
            studentRepository.findByBranch(branch).forEach(studentEntity -> {
                StudentOutputDTO studentOutputDTO = new StudentOutputDTO(studentEntity);
                studentOutputDTOList.add(studentOutputDTO);
            });

            return studentOutputDTOList;
        }

        List<StudentOutputDTO> studentOutputDTOListVacia = new ArrayList<>();
        return studentOutputDTOListVacia;
    }
}
