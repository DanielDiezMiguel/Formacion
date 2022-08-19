package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hola")
public class LoginPersonaController {
    @GetMapping
    String saludo() {
        return "hola";
    }
}
//public class LoginPersonaController {
//
////    @GetMapping
////    public String login() {
////        return "Login required";
////    }
//
//}
