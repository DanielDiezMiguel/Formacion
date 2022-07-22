package com.bosonit.infrastructure.controller;

import com.bosonit.application.port.UpdatePersonaPort;
import com.bosonit.infrastructure.controller.dto.input.UsuarioInputDTO;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {

    @Autowired
    UpdatePersonaPort updatePersonaPort;

    @PutMapping("/usuario/update/{id}")
    public UsuarioOutputDTO updateUsuarioByID(@PathVariable(value = "id") Integer id, @RequestBody UsuarioInputDTO usuarioInputDTO) {
        return updatePersonaPort.updateUsuarioByID(id, usuarioInputDTO);
    }
}
