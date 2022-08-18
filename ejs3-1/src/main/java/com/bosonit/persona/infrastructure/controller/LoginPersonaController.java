package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginPersonaController {

    @PostMapping
    public PersonaOutputDTO login(@RequestParam("user") String user, @RequestParam("password") String password) {
        return new PersonaOutputDTO(new PersonaEntity());
    }

}
