package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.ReadPersonaPort;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
@RequestMapping("persona")
public class ReadPersonaController {

    @Autowired
    ReadPersonaPort readPersonaPort;

    @GetMapping("/getAll")
    public List<PersonaOutputDTO> getAll() {
        return readPersonaPort.selectAll();
    }

    @GetMapping("/id")
    public List<PersonaOutputDTO> getByID(@RequestParam(value = "id") Integer id) {
        return readPersonaPort.selectByID(id);
    }

}
