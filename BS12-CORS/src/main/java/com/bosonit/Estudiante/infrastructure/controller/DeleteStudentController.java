package com.bosonit.Estudiante.infrastructure.controller;

import com.bosonit.Estudiante.application.port.DeleteStudentPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class DeleteStudentController {

    @Autowired
    DeleteStudentPort deleteStudentPort;

    @DeleteMapping("{id}")
    public void deleteByID(@PathVariable(name = "id") String id) throws Exception {
        deleteStudentPort.deleteByID(id);
    }
}
