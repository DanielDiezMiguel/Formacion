package com.bosonit.infrastructure.controller;

import com.bosonit.application.port.CreatePersonaPort;
import com.bosonit.application.port.DeletePersonaPort;
import com.bosonit.application.port.UpdatePersonaPort;
import com.bosonit.infrastructure.controller.dto.input.UsuarioInputDTO;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateController {

    @Autowired
    CreatePersonaPort createPersonaPort;

    @PostMapping("/usuario/crearUsuario")
    public UsuarioOutputDTO crearUsuario(@RequestBody UsuarioInputDTO usuarioInputDTO) throws Exception {
        return createPersonaPort.crearUsuario(usuarioInputDTO);
    }
}


