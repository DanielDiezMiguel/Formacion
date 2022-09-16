package com.bosonit.Mapping.infrastructure.controller;

import com.bosonit.Mapping.application.port.PersonaCreatePort;
import com.bosonit.Mapping.infrastructure.controller.dto.PersonaInputDTO;
import com.bosonit.Mapping.infrastructure.controller.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaCreateController {

  @Autowired PersonaCreatePort personaCreatePort;

  @PostMapping
  public PersonaOutputDTO createPersona(@RequestBody PersonaInputDTO personaInputDTO) {
    return personaCreatePort.crearPersona(personaInputDTO);
  }
}
