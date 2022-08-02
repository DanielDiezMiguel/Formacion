package com.bosonit.EstudianteAsignatura.infrastructure.controller;

import com.bosonit.EstudianteAsignatura.application.port.UpdateEstudianteAsignaturaPort;
import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.input.EstudianteAsignaturaInputDTO;
import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("estudianteAsignatura")
public class UpdateEstudianteAsignaturaController {

    @Autowired
    UpdateEstudianteAsignaturaPort updateEstudianteAsignaturaPort;

    @PutMapping("{id}")
    @Operation(summary = "Actualizar Estudiante_Asignatura")
    public EstudianteAsignaturaOutputDTO updateEstudianteAsignatura(@PathVariable(name = "id") String id, @RequestBody EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) throws Exception {
        return updateEstudianteAsignaturaPort.updateEstudianteAsignatura(id, estudianteAsignaturaInputDTO);
    }
}
