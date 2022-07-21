package com.bosonit.application.port;

import com.bosonit.domain.UsuarioEntity;
import com.bosonit.infrastructure.controller.dto.input.UsuarioInputDTO;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface UpdatePersonaPort {

    public UsuarioOutputDTO updateUsuarioByID(@PathVariable(value = "id") Integer id, UsuarioInputDTO usuarioInputDTO);
}
