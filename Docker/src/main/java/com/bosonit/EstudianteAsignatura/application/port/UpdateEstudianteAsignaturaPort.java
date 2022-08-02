package com.bosonit.EstudianteAsignatura.application.port;

import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.input.EstudianteAsignaturaInputDTO;
import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;

public interface UpdateEstudianteAsignaturaPort {
    EstudianteAsignaturaOutputDTO updateEstudianteAsignatura(String id, EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) throws Exception;
}
