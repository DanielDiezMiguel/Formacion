package com.bosonit.Estudiante.infrastructure.controller;

import com.bosonit.Estudiante.application.port.ReadStudentPort;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class ReadStudentController {

    @Autowired
    ReadStudentPort readStudentPort;

    @GetMapping("{id}")
    public StudentOutputDTO getStudentByID(@PathVariable(name = "id") String id) throws Exception {
        return readStudentPort.getStudentByID(id);
    }

    @GetMapping("all")
    public List<StudentOutputDTO> getAllStudents() {
        return readStudentPort.getAllStudents();
    }

    @GetMapping("branch/{branch}")
    public List<StudentOutputDTO> getStudentByBranch(@PathVariable(name = "branch") String branch) {
        return readStudentPort.getStudentByBranch(branch);
    }
}
