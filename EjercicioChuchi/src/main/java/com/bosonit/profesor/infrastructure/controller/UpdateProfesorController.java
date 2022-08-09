package com.bosonit.profesor.infrastructure.controller;

import com.bosonit.profesor.application.port.UpdateProfesorPort;
import com.bosonit.profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.bosonit.profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profesor")
public class UpdateProfesorController {

    @Autowired
    UpdateProfesorPort updateProfesorPort;

    @PutMapping("{id}")
    public ProfesorOutputDTO updateProfesor(@PathVariable(name = "id") String id, @RequestBody ProfesorInputDTO profesorInputDTO) throws Exception {
        return updateProfesorPort.updateProfesor(id, profesorInputDTO);
    }
}
