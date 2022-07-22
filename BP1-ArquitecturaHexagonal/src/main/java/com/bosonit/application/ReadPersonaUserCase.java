package com.bosonit.application;

import com.bosonit.application.port.ReadPersonaPort;
import com.bosonit.domain.UsuarioEntity;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import com.bosonit.infrastructure.repository.jpa.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadPersonaUserCase implements ReadPersonaPort {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public UsuarioOutputDTO getUsuarioByID(Integer id) {
        UsuarioEntity usuarioEntity = usuarioRepositorio.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado el ID"));
        return new UsuarioOutputDTO(usuarioEntity);

    }

    @Override
    public List<UsuarioOutputDTO> getAllUsuarios() {
        List<UsuarioOutputDTO> usuarioOutputDTOList = new ArrayList<>();
        usuarioRepositorio.findAll().forEach(persona -> {
            UsuarioOutputDTO usuarioOutputDTO = new UsuarioOutputDTO(persona);
            usuarioOutputDTOList.add(usuarioOutputDTO);
        });

        return usuarioOutputDTOList;
    }

    @Override
    public List<UsuarioOutputDTO> getUsuarioByName(String name) {
        List<UsuarioOutputDTO> usuarioOutputDTOList = new ArrayList<>();
        usuarioRepositorio.findByName(name).forEach(persona -> {
        usuarioOutputDTOList.add(persona);

        });
        return usuarioOutputDTOList;
    }


}
