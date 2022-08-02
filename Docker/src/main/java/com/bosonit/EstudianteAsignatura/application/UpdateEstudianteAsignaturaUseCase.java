package com.bosonit.EstudianteAsignatura.application;

import com.bosonit.EstudianteAsignatura.application.port.UpdateEstudianteAsignaturaPort;
import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.input.EstudianteAsignaturaInputDTO;
import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;
import com.bosonit.EstudianteAsignatura.infrastructure.repository.jpa.EstudianteAsignaturaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateEstudianteAsignaturaUseCase implements UpdateEstudianteAsignaturaPort {

    @Autowired
    EstudianteAsignaturaRespository estudianteAsignaturaRespository;

    @Override
    public EstudianteAsignaturaOutputDTO updateEstudianteAsignatura(String id, EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) throws Exception{
        EstudianteAsignaturaEntity estudianteAsignaturaEntity = estudianteAsignaturaRespository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado el ID: " + id));
        estudianteAsignaturaEntity.update(estudianteAsignaturaInputDTO);
        return new EstudianteAsignaturaOutputDTO(estudianteAsignaturaRespository.save(estudianteAsignaturaEntity));
    }
}
