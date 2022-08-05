package com.bosonit.estudianteAsignatura.application.port;

import com.bosonit.estudianteAsignatura.infrastructure.controller.dto.input.EstudianteAsignaturaInputDTO;
import com.bosonit.estudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;

public interface CreateEstudianteAsignaturaPort {

    EstudianteAsignaturaOutputDTO crearEstudianteAsignatura(EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) throws Exception;
}
