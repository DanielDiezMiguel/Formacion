package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.DeletePersonaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persona")
public class DeletePersonaController {

    @Autowired
    DeletePersonaPort deletePersonaPort;

    @DeleteMapping("/id")
    public void deleteByID(@RequestParam(value = "id") Integer id) {
        deletePersonaPort.deleteByID(id);
    }
}
