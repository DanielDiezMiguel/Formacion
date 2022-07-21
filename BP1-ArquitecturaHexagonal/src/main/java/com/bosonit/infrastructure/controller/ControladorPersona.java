package com.bosonit.infrastructure.controller;

import com.bosonit.application.port.CreatePersonaPort;
import com.bosonit.application.port.DeletePersonaPort;
import com.bosonit.application.port.UpdatePersonaPort;
import com.bosonit.infrastructure.controller.dto.input.UsuarioInputDTO;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import com.bosonit.domain.UsuarioEntity;
import com.bosonit.infrastructure.repository.jpa.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorPersona {

    @Autowired
    CreatePersonaPort createPersonaPort;

    @Autowired
    UpdatePersonaPort updatePersonaPort;

    @Autowired
    DeletePersonaPort deletePersonaPort;

    // CREATE
    @PostMapping("/crearUsuario")
    public UsuarioOutputDTO crearUsuario(@RequestBody UsuarioInputDTO usuarioInputDTO) throws Exception {
        return createPersonaPort.crearUsuario(usuarioInputDTO);
    }

    // UPDATE
    @PutMapping("/usuario/update/{id}")
    public UsuarioOutputDTO updateUsuarioByID(@PathVariable(value = "id") Integer id, @RequestBody UsuarioInputDTO usuarioInputDTO) {
        return updatePersonaPort.updateUsuarioByID(id, usuarioInputDTO);
    }

    // DELETE
    @DeleteMapping("/usuario/delete/{id}")
    public void deleteByID(@PathVariable(value = "id") Integer id) {
        deletePersonaPort.deleteByID(id);
    }


//    @GetMapping("/id/{id}")
//    public Optional<UsuarioEntity> getUsuarioByID(@PathVariable(value = "id") Integer id) {
//        return usuarioRepositorio.findById(id);
//    }
//
//
//    @GetMapping("/usuario/{usuario}")
//    public List<UsuarioEntity> getUsuarioByUser(@PathVariable(value = "usuario") String usuario) {
//        return usuarioRepositorio.findByUsuario(usuario);
//    }
//
//    @GetMapping("/usuario/all")
//    public List<UsuarioEntity> getAllUsuarios() {
//        return usuarioRepositorio.findAll();
//    }
}


