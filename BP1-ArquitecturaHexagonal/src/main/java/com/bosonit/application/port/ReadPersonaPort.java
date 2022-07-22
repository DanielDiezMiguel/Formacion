package com.bosonit.application.port;

import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;

import java.util.List;

public interface ReadPersonaPort {
    UsuarioOutputDTO getUsuarioByID(Integer id);
    List<UsuarioOutputDTO> getAllUsuarios();
    List<UsuarioOutputDTO> getUsuarioByName(String name);
}
