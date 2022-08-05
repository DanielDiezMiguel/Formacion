package com.bosonit.profesor.infrastructure.controller;

import com.bosonit.profesor.application.port.DeleteProfesorPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profesor")
public class DeleteProfesorController {

    @Autowired
    DeleteProfesorPort deleteProfesorPort;

    @DeleteMapping("{id}")
    public void deleteProfesorByID(@PathVariable(name = "id") String id) throws Exception {
        deleteProfesorPort.deleteProfesorByID(id);
    }

}
