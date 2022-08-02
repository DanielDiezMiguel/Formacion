package com.bosonit.DevTools.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevToolsController {

    @GetMapping("/hola")
    public String getHola() {
        return "Hola";
    }

}
