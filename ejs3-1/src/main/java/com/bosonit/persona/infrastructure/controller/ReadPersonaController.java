package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.ReadPersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/persona/read")
public class ReadPersonaController {

    @Autowired
    ReadPersonaPort readPersonaPort;

    @GetMapping("/all/all")
    public ResponseEntity<List<PersonaOutputDTO>>getUsers() {
        return ResponseEntity.ok().body(readPersonaPort.getAllPrueba());
    }

    @GetMapping("/id/{id}")
    public PersonaOutputDTO getUsuarioByID(@PathVariable(value = "id") String id, @RequestParam(defaultValue = "persona", required = false) String outputType) throws Exception {
        return readPersonaPort.getPersonaByID(id, outputType);
    }

    @GetMapping("/all/outputType")
    public List<PersonaOutputDTO> getAllUsuarios(@RequestParam(defaultValue = "persona", required = false) String outputType) {
        return readPersonaPort.getAllUsuarios(outputType);
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaOutputDTO> getUsuarioByName(@PathVariable(value = "nombre") String nombre, @RequestParam(defaultValue = "persona", required = false) String outputType) {
        return readPersonaPort.getPersonaByName(nombre, outputType);
    }
}
