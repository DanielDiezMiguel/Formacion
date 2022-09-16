package com.bosonit.Mapping.application;

import com.bosonit.Mapping.application.port.PersonaCreatePort;
import com.bosonit.Mapping.application.port.PersonaMapper;
import com.bosonit.Mapping.domain.Persona;
import com.bosonit.Mapping.infrastructure.controller.dto.PersonaInputDTO;
import com.bosonit.Mapping.infrastructure.controller.dto.PersonaOutputDTO;
import com.bosonit.Mapping.infrastructure.repository.jpa.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaCreateUseCase implements PersonaCreatePort {

  //  private final PersonaMapper personaMapper;
  @Autowired PersonaRepository personaRepository;

  @Override
  public PersonaOutputDTO crearPersona(PersonaInputDTO personaInputDTO) {
    return PersonaMapper.INSTANCE.personaOutputDto(
            personaRepository.save(PersonaMapper.INSTANCE.persona(personaInputDTO)));
  }
}
