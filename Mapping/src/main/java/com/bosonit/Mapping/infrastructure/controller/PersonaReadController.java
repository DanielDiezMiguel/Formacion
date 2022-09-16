package com.bosonit.Mapping.infrastructure.controller;

import com.bosonit.Mapping.application.port.PersonaReadPort;
import com.bosonit.Mapping.infrastructure.controller.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaReadController {

  @Autowired PersonaReadPort personaReadPort;

  @GetMapping("/all")
  public List<PersonaOutputDTO> getAll() {
    return personaReadPort.getAll();
  }
}
