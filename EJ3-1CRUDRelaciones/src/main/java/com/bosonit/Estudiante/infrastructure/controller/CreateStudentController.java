package com.bosonit.Estudiante.infrastructure.controller;

import com.bosonit.Estudiante.application.port.CreateStudentPort;
import com.bosonit.Estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateStudentController {

    @Autowired
    CreateStudentPort createStudentPort;

    @PostMapping("/student/crearStudent")
    public StudentOutputDTO crearStudent(@RequestBody StudentInputDTO studentInputDTO) throws Exception {
        return createStudentPort.crearStudent(studentInputDTO);
    }
}
