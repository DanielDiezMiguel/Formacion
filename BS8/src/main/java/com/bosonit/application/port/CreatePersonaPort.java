package com.bosonit.application.port;

import com.bosonit.domain.UsuarioEntity;
import com.bosonit.infrastructure.controller.dto.input.UsuarioInputDTO;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface CreatePersonaPort {
    public UsuarioOutputDTO crearUsuario(UsuarioInputDTO usuarioInputDTO);
}
