package com.bosonit.application;

import com.bosonit.application.port.UpdatePersonaPort;
import com.bosonit.domain.UsuarioEntity;
import com.bosonit.infrastructure.controller.dto.input.UsuarioInputDTO;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import com.bosonit.infrastructure.repository.jpa.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdatePersonaUseCase implements UpdatePersonaPort {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Override
    public UsuarioOutputDTO updateUsuarioByID(Integer id, UsuarioInputDTO usuarioInputDTO) {
        UsuarioEntity usuarioEntity = usuarioRepositorio.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        usuarioEntity.update(usuarioInputDTO);
        usuarioRepositorio.save(usuarioEntity);
        return new UsuarioOutputDTO(usuarioEntity);
    }
}
