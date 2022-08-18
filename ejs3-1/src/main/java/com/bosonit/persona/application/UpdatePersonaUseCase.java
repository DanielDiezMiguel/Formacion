package com.bosonit.persona.application;

import com.bosonit.persona.application.port.UpdatePersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.exception.NotFoundException;
import com.bosonit.persona.exception.UnprocesableException;
import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonaUseCase implements UpdatePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO updateUsuarioByID(String id, PersonaInputDTO personaInputDTO) {
        try {
            PersonaEntity personaEntity = personaRepository.findById(id).orElseThrow();
            personaEntity.update(personaInputDTO);
            personaRepository.save(personaEntity);
            return new PersonaOutputDTO(personaEntity);

        } catch (Exception e) {
            if (!personaRepository.findById(id).isPresent()) throw new NotFoundException("No se ha encontrado el ID");
            else throw new UnprocesableException("No cumple los requisitos establecidos");
        }
    }
}