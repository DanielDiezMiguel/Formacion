package com.bosonit.Profesor.infrastructure.controller;

import com.bosonit.Profesor.application.port.DeleteProfesorPort;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Borrar Profesor por ID")
    public void deleteProfesorByID(@PathVariable(name = "id") String id) throws Exception {
        deleteProfesorPort.deleteProfesorByID(id);
    }

}