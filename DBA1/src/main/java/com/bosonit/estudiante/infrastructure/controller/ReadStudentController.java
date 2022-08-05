package com.bosonit.estudiante.infrastructure.controller;

import com.bosonit.estudiante.application.port.ReadStudentPort;
import com.bosonit.estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
//import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputFullDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class ReadStudentController {

    @Autowired
    ReadStudentPort readStudentPort;

    @GetMapping("{id}")
    public StudentOutputDTO getStudentByID(@PathVariable(name = "id") String id, @RequestParam(defaultValue = "simple", required = false) String ouputType) throws Exception {
        return readStudentPort.getStudentByID(id, ouputType);

    }

    @GetMapping("all/all")
    public List<StudentOutputDTO> getAllStudents() {
        return readStudentPort.getAllStudents();
    }

    @GetMapping("branch/{branch}")
    public List<StudentOutputDTO> getStudentByBranch(@PathVariable(name = "branch") String branch) {
        return readStudentPort.getStudentByBranch(branch);
    }
}
