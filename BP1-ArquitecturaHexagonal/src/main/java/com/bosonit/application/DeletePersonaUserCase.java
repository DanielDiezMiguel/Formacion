package com.bosonit.application;

import com.bosonit.application.port.DeletePersonaPort;
import com.bosonit.domain.UsuarioEntity;
import com.bosonit.infrastructure.controller.dto.input.UsuarioInputDTO;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import com.bosonit.infrastructure.repository.jpa.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUserCase implements DeletePersonaPort {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    public void deleteByID(Integer id) {
        UsuarioEntity usuarioEntity = usuarioRepositorio.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado el ID"));
        usuarioRepositorio.delete(usuarioEntity);
        usuarioRepositorio.save(usuarioEntity);
    }
}
