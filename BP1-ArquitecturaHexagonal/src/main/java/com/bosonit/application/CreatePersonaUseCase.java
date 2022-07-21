package com.bosonit.application;

import com.bosonit.application.port.CreatePersonaPort;
import com.bosonit.domain.UsuarioEntity;
import com.bosonit.infrastructure.controller.dto.input.UsuarioInputDTO;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import com.bosonit.infrastructure.repository.jpa.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CreatePersonaUseCase implements CreatePersonaPort {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public UsuarioOutputDTO crearUsuario(UsuarioInputDTO usuarioInputDTO) throws Exception {
        if (usuarioInputDTO.getUsuario().length() < 6 || usuarioInputDTO.getUsuario().length() > 10)
            throw new Exception("El usuario debe tener entre 6 y 10 carácteres");

        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioInputDTO);
        usuarioRepositorio.save(usuarioEntity);
        UsuarioOutputDTO usuarioOutputDTO = new UsuarioOutputDTO(usuarioEntity);
        return usuarioOutputDTO;
    }
}
