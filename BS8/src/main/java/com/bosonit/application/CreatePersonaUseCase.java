package com.bosonit.application;

import com.bosonit.application.port.CreatePersonaPort;
import com.bosonit.domain.UsuarioEntity;
import com.bosonit.exception.UnprocesableException;
import com.bosonit.infrastructure.controller.dto.input.UsuarioInputDTO;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import com.bosonit.infrastructure.repository.jpa.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class CreatePersonaUseCase implements CreatePersonaPort {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public UsuarioOutputDTO crearUsuario(@Valid UsuarioInputDTO usuarioInputDTO) {
        try {
            UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioInputDTO);
            usuarioRepositorio.save(usuarioEntity);
            UsuarioOutputDTO usuarioOutputDTO = new UsuarioOutputDTO(usuarioEntity);
            return usuarioOutputDTO;

        } catch (Exception e) {
            throw new UnprocesableException("Los campos no cumplen las condiciones establecidas");
        }

    }
}
