package com.bosonit.application;

import com.bosonit.application.port.UpdatePersonaPort;
import com.bosonit.domain.UsuarioEntity;
import com.bosonit.exception.NotFoundException;
import com.bosonit.exception.UnprocesableException;
import com.bosonit.infrastructure.controller.dto.input.UsuarioInputDTO;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import com.bosonit.infrastructure.repository.jpa.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Service
public class UpdatePersonaUseCase implements UpdatePersonaPort {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public UsuarioOutputDTO updateUsuarioByID(Integer id, UsuarioInputDTO usuarioInputDTO) {
        try {
            UsuarioEntity usuarioEntity =  usuarioRepositorio.findById(id).orElseThrow();
            usuarioEntity.update(usuarioInputDTO);
            usuarioRepositorio.save(usuarioEntity);
            return new UsuarioOutputDTO(usuarioEntity);

        } catch (Exception e) {
            if (!usuarioRepositorio.findById(id).isPresent()) {
                throw new NotFoundException("No se ha encontrado el ID");
            }
            throw new UnprocesableException("No cumple los requisitos establecidos");
        }
    }
}
