package com.bosonit.EstudianteAsignatura.infrastructure.controller;

import com.bosonit.Estudiante.application.port.DeleteStudentPort;
import com.bosonit.EstudianteAsignatura.application.port.DeleteEstudianteAsignaturaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estudianteAsignatura")
public class DeleteEstudianteAsignaturaConroller {

    @Autowired
    DeleteEstudianteAsignaturaPort deleteEstudianteAsignaturaPort;

    @DeleteMapping("{id}")
    public void deleteByID(@PathVariable(name = "id") String id) throws Exception {
        deleteEstudianteAsignaturaPort.deleteByID(id);
    }
}
