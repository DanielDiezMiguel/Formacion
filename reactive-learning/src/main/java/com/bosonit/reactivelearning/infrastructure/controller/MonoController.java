package com.bosonit.reactivelearning.infrastructure.controller;

import com.bosonit.reactivelearning.application.port.MonoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mono")
public class MonoController {

    @Autowired
    MonoPort monoPort;

    @GetMapping
    public Mono<Integer> integerMono() {
        return monoPort.integerMono();
    }

}
