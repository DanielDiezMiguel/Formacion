package com.bosonit.infrastructure.controller;

import com.bosonit.application.port.ReadPersonaPort;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class ReadController {

    @Autowired
    ReadPersonaPort readPersonaPort;

    @GetMapping("/usuario/read/id/{id}")
    public UsuarioOutputDTO getUsuarioByID(@PathVariable(value = "id") Integer id) {
        return readPersonaPort.getUsuarioByID(id);
    }

    @GetMapping("/usuario/read/all")
    public List<UsuarioOutputDTO> getAllUsuarios() {
        return readPersonaPort.getAllUsuarios();
    }

    @GetMapping("/usuario/read/name/{nombre}")
    public List<UsuarioOutputDTO> getUsuarioByName(@PathVariable(value = "nombre") String nombre) {
        return readPersonaPort.getUsuarioByName(nombre);
    }
}
