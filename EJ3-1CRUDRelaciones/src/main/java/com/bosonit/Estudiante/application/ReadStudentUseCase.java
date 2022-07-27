package com.bosonit.Estudiante.application;

import com.bosonit.Estudiante.application.port.ReadStudentPort;
import com.bosonit.Estudiante.domain.StudentEntity;
import com.bosonit.Estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
//import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputFullDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputFullDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputSimpleDTO;
import com.bosonit.Estudiante.infrastructure.repository.jpa.StudentRepository;
import com.bosonit.Persona.domain.PersonaEntity;
import com.bosonit.Persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadStudentUseCase implements ReadStudentPort {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public StudentOutputDTO getStudentSimpleByID(String id, String outType) throws Exception {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado el ID de Estudiante"));
        if (outType.equalsIgnoreCase("simple"))
            return new StudentOutputSimpleDTO(studentEntity);
        else
            return new StudentOutputFullDTO(studentEntity);
    }
    @Override
    public StudentOutputFullDTO getStudentFullByID(String id, StudentInputDTO studentInputDTO) throws Exception {
        return null;
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
