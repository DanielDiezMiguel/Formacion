package com.bosonit.persona.application;

import com.bosonit.persona.application.port.UpdatePersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.exception.NotFoundException;
import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.persona.infrastructure.repository.mongo.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UpdatePersonaUseCase implements UpdatePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO updateUsuarioByID(int id, PersonaInputDTO personaInputDTO) {
        PersonaEntity personaEntity = personaRepository.findById(String.valueOf(id)).orElseThrow(() -> new NotFoundException("No se ha encontrado a la PersonaEntity con ID: " + id));
        personaEntity.update(personaInputDTO);
        personaRepository.save(personaEntity);
        return new PersonaOutputDTO(personaEntity);

    }
}
