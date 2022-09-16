package com.bosonit.Mapping.application;

import com.bosonit.Mapping.application.port.PersonaMapper;
import com.bosonit.Mapping.application.port.PersonaReadPort;
import com.bosonit.Mapping.infrastructure.controller.dto.PersonaOutputDTO;
import com.bosonit.Mapping.infrastructure.repository.jpa.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaReadUseCase implements PersonaReadPort {

  private final PersonaMapper personaMapper;
  @Autowired PersonaRepository personaRepository;

  @Override
  public List<PersonaOutputDTO> getAll() {
    List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
    personaRepository
        .findAll()
        .forEach(persona -> personaOutputDTOList.add(personaMapper.personaOutputDto(persona)));
    return personaOutputDTOList;
  }
}
