package com.bosonit.Mapping.application.port;

import com.bosonit.Mapping.domain.Persona;
import com.bosonit.Mapping.infrastructure.controller.dto.PersonaInputDTO;
import com.bosonit.Mapping.infrastructure.controller.dto.PersonaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonaMapper {

  PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "nombre", source = "nombre")
  @Mapping(target = "apellidos", source = "apellidos")
  @Mapping(target = "edad", source = "edad")
  Persona persona(PersonaInputDTO personaInputDTO);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "nombre", source = "nombre")
  @Mapping(target = "apellidos", source = "apellidos")
  @Mapping(target = "edad", source = "edad")
  PersonaOutputDTO personaOutputDto(Persona persona);
  //    List<PersonaOutputDTO> personaOutputDtoList(List<Persona> personaList);
}
