package com.bosonit.estudiante.infrastructure.controller;

import com.bosonit.estudiante.application.port.UpdateStudentPort;
import com.bosonit.estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
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
