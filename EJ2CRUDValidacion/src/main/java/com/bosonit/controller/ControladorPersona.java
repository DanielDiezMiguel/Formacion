package com.bosonit.controller;

import com.bosonit.dto.UsuarioDTO;
import com.bosonit.model.Usuario;
import com.bosonit.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ControladorPersona {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

//    @GetMapping("/{id}")
//    public void getUsuarioByID(@PathVariable(value = "id") Integer id, Usuario usuario) {
//        Usuario usuario = usuarioRepositorio.findById(id);
//        UsuarioDTO usuarioDTO = new UsuarioDTO();
//        usuarioDTO.setId_persona(usuario.getId_persona());
//        usuarioRepositorio.findAllById(id);
//    }

    @PostMapping("/crearUsuario")
    public Usuario crearUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        if (usuarioDTO.getUsuario().length() < 6 || usuarioDTO.getUsuario().length() > 10)
            throw new Exception("El usuario debe tener entre 6 y 10 carácteres");

            Usuario usuario = new Usuario(usuarioDTO);
            usuarioRepositorio.save(usuario);
            return usuario;

    }
}
