package com.bosonit.reactivelearning.infrastructure.controller;

import com.bosonit.reactivelearning.application.port.FluxPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/flux")
public class FluxController {

  @Autowired FluxPort fluxPort;

  @GetMapping
  public Flux<Integer> integerFlux() {
    return fluxPort.integerFlux();
  }

  @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Integer> integerStreamFlux() {
    return fluxPort.integerStreamFlux();
  }
}
