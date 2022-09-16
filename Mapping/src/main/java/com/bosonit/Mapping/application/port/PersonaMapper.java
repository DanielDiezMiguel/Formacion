package com.bosonit.Mapping.application.port;

import com.bosonit.Mapping.domain.PersonaEntity;
import com.bosonit.Mapping.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.Mapping.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Se realiza la conversión de DTO
 * @author Daniel Díez Miguel
 */
@Mapper
public interface PersonaMapper {

  PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "nombre", source = "nombre")
  @Mapping(target = "apellidos", source = "apellidos")
  @Mapping(target = "edad", source = "edad")
  PersonaEntity persona(PersonaInputDTO personaInputDTO);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "nombre", source = "nombre")
  @Mapping(target = "apellidos", source = "apellidos")
  @Mapping(target = "edad", source = "edad")
  PersonaOutputDTO personaOutputDto(PersonaEntity personaEntity);
}
