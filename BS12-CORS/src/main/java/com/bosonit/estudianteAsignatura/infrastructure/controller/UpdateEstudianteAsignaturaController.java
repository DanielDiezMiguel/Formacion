package com.bosonit.estudianteAsignatura.infrastructure.controller;

import com.bosonit.estudianteAsignatura.application.port.UpdateEstudianteAsignaturaPort;
import com.bosonit.estudianteAsignatura.infrastructure.controller.dto.input.EstudianteAsignaturaInputDTO;
import com.bosonit.estudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("estudianteAsignatura")
public class UpdateEstudianteAsignaturaController {

    @Autowired
    UpdateEstudianteAsignaturaPort updateEstudianteAsignaturaPort;

    @PutMapping("{id}")
    public EstudianteAsignaturaOutputDTO updateEstudianteAsignatura(@PathVariable(name = "id") String id, @RequestBody EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) throws Exception {
        return updateEstudianteAsignaturaPort.updateEstudianteAsignatura(id, estudianteAsignaturaInputDTO);
    }
}
