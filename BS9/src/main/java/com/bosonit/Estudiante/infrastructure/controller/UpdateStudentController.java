package com.bosonit.Estudiante.infrastructure.controller;

import com.bosonit.Estudiante.application.port.UpdateStudentPort;
import com.bosonit.Estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class UpdateStudentController {

    @Autowired
    UpdateStudentPort updateStudentPort;

    @PutMapping("{id}")
    public StudentOutputDTO updateByID(@RequestBody StudentInputDTO studentInputDTO, @PathVariable(name = "id") String id) throws Exception {
        return updateStudentPort.updateByID(studentInputDTO, id);
    }
}
