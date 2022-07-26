package com.bosonit.Estudiante.infrastructure.controller;

import com.bosonit.Estudiante.application.port.ReadStudentPort;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
//import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputFullDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputSimpleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class ReadStudentController {

    @Autowired
    ReadStudentPort readStudentPort;

    @GetMapping("{id}")
    public Object getStudentByID(@PathVariable(name = "id") String id, @RequestParam(defaultValue = "simple", required = false) String ouputType) throws Exception {
        if (ouputType != null) {

            if (ouputType.equalsIgnoreCase("simple")) {
                return readStudentPort.getStudentSimpleByID(id);

            } else if (ouputType.equalsIgnoreCase("full")) {
//                return readStudentPort.getStudentFullByID(id);
            }
        }
        return null;
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
