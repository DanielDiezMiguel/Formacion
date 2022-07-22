package com.bosonit.application;

import com.bosonit.application.port.ReadPersonaPort;
import com.bosonit.domain.UsuarioEntity;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import com.bosonit.infrastructure.repository.jpa.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadPersonaUserCase implements ReadPersonaPort {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public UsuarioOutputDTO getUsuarioByID(Integer id) {
        UsuarioEntity usuarioEntity = usuarioRepositorio.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new UsuarioOutputDTO(usuarioEntity);

    }

    @Override
    public List<UsuarioOutputDTO> getAllUsuarios() {
        List<UsuarioOutputDTO> usuarioOutputDTOList = new ArrayList<>();
        if (usuarioRepositorio.findAll() != null) {
            usuarioRepositorio.findAll().forEach(persona -> {
                UsuarioOutputDTO usuarioOutputDTO = new UsuarioOutputDTO(persona);
                usuarioOutputDTOList.add(usuarioOutputDTO);
            });
            return usuarioOutputDTOList;

        }
        List<UsuarioOutputDTO> usuarioOutputDTOListVacia = new ArrayList<>();
        return usuarioOutputDTOListVacia;

    }

    @Override
    public List<UsuarioOutputDTO> getUsuarioByName(String name) {
        List<UsuarioOutputDTO> usuarioOutputDTOList = new ArrayList<>();
        if (usuarioRepositorio.findByName(name) != null) {
            usuarioRepositorio.findByName(name).forEach(persona -> {
                UsuarioOutputDTO usuarioOutputDTO = new UsuarioOutputDTO(persona);
                usuarioOutputDTOList.add(usuarioOutputDTO);
            });
            return usuarioOutputDTOList;
        }
        List<UsuarioOutputDTO> usuarioOutputDTOListVacia = new ArrayList<>();
        return usuarioOutputDTOListVacia;
    }

}
