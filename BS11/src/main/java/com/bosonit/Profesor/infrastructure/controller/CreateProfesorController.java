package com.bosonit.Profesor.infrastructure.controller;

import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import com.bosonit.Profesor.application.port.CreateProfesorPort;
import com.bosonit.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.bosonit.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profesor")
public class CreateProfesorController {

    @Autowired
    CreateProfesorPort createProfesorPort;

    @PostMapping
    @Operation(summary = "Crear Profesor")
    public ProfesorOutputDTO crearProfesor(@RequestBody ProfesorInputDTO profesorInputDTO) throws Exception {
        return createProfesorPort.crearProfesor(profesorInputDTO);
    }
}
