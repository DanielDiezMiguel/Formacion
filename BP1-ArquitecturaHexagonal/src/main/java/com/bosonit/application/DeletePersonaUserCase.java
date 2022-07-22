package com.bosonit.application;

import com.bosonit.application.port.DeletePersonaPort;
import com.bosonit.domain.UsuarioEntity;
import com.bosonit.infrastructure.controller.dto.input.UsuarioInputDTO;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import com.bosonit.infrastructure.repository.jpa.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeletePersonaUserCase implements DeletePersonaPort {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    public void deleteByID(Integer id) {
        UsuarioEntity usuarioEntity = usuarioRepositorio.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        usuarioRepositorio.delete(usuarioEntity);
        usuarioRepositorio.save(usuarioEntity);
    }
}
