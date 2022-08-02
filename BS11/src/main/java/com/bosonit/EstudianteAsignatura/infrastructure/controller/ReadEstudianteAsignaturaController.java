package com.bosonit.EstudianteAsignatura.infrastructure.controller;

import com.bosonit.EstudianteAsignatura.application.port.ReadEstudianteAsignaturaPort;
import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Obtener Estudiante_Asignatura por ID")
    public EstudianteAsignaturaOutputDTO getAsignaturaByEstudianteID(@PathVariable(value = "id") String id) throws Exception {
        return readEstudianteAsignaturaPort.getAsignaturaByEstudianteID(id);
    }
}
