package com.bosonit.application.port;

import com.bosonit.infrastructure.controller.dto.input.UsuarioInputDTO;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;

public interface DeletePersonaPort {
    void deleteByID(Integer id);

}
