package com.bosonit.EstudianteAsignatura.infrastructure.controller;

import com.bosonit.EstudianteAsignatura.application.port.CreateEstudianteAsignaturaPort;
import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.input.EstudianteAsignaturaInputDTO;
import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estudianteAsignatura")
public class CreateEstudianteAsignaturaController {

    @Autowired
    CreateEstudianteAsignaturaPort createEstudianteAsignaturaPort;

    @PostMapping
    @Operation(summary = "Crear Estudiante_Asignatura")
    public EstudianteAsignaturaOutputDTO crearEstudianteAsignatura(@RequestBody EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) throws Exception {
        return createEstudianteAsignaturaPort.crearEstudianteAsignatura(estudianteAsignaturaInputDTO);
    }
}
