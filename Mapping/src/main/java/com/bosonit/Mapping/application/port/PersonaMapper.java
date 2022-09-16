package com.bosonit.Mapping.application.port;

import com.bosonit.Mapping.domain.Persona;
import com.bosonit.Mapping.infrastructure.controller.dto.PersonaInputDTO;
import com.bosonit.Mapping.infrastructure.controller.dto.PersonaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    Persona persona(PersonaInputDTO personaInputDTO);
    PersonaOutputDTO personaOutputDto(Persona persona);
    List<PersonaOutputDTO> personaOutputDtoList(List<Persona> personaList);
}
