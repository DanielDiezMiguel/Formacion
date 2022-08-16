package com.bosonit.persona.application;

import com.bosonit.persona.application.port.UpdatePersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
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
    public PersonaOutputDTO updateUsuarioByID(Integer id, PersonaInputDTO personaInputDTO) throws Exception {
        PersonaEntity personaEntity = personaRepository.findById(id).orElseThrow(() -> new Exception("No se ha eonctrado el ID: " + id));
        personaEntity.update(personaInputDTO);
        personaRepository.save(personaEntity);
        return new PersonaOutputDTO(personaEntity);
    }
}