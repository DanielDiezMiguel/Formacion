package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.PersonaReadPort;
import com.bosonit.persona.infrastructure.controller.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("persona")
public class PersonaReadController {

    @Autowired
    PersonaReadPort personaReadPort;

    @GetMapping("id/{id}")
    public PersonaOutputDTO getPersonaByID(@PathVariable(name = "id") Integer id) throws Exception {
        return personaReadPort.getPersonaByID(id);
    }

    @GetMapping("all/all")
    public List<PersonaOutputDTO> getAllPersonas() throws Exception {
        return personaReadPort.getAllPersonas();
    }

    @GetMapping("usuario/{usuario}")
    public List<PersonaOutputDTO> getPersonaByUsuario(@PathVariable(name = "usuario") String usuario) throws Exception {
        return personaReadPort.getPersonaByUsuario(usuario);
    }
}
