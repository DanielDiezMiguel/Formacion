package com.bosonit.Profesor.application;

import com.bosonit.Profesor.application.port.UpdateProfesorPort;
import com.bosonit.Profesor.domain.ProfesorEntity;
import com.bosonit.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.bosonit.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import com.bosonit.Profesor.infrastructure.repository.jpa.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfesorUseCase implements UpdateProfesorPort {

    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public ProfesorOutputDTO updateProfesor(String id, ProfesorInputDTO profesorInputDTO) throws Exception{
        ProfesorEntity profesorEntity = profesorRepository.findById(id).orElseThrow(() -> new Exception("No se ha podido actualizar el Pofesor con ID: " + id));
        profesorEntity.update(profesorInputDTO);
        profesorRepository.save(profesorEntity);
        return new ProfesorOutputDTO(profesorEntity);
    }
}
