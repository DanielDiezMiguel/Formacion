package com.bosonit.estudianteAsignatura.infrastructure.controller;

import com.bosonit.estudianteAsignatura.application.port.ReadEstudianteAsignaturaPort;
import com.bosonit.estudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estudianteAsignatura")
public class ReadEstudianteAsignaturaController {
    @Autowired
    ReadEstudianteAsignaturaPort readEstudianteAsignaturaPort;

    @GetMapping("{id}")
    public EstudianteAsignaturaOutputDTO getAsignaturaByEstudianteID(@PathVariable(value = "id") String id) throws Exception {
        return readEstudianteAsignaturaPort.getAsignaturaByEstudianteID(id);
    }
}
