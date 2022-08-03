package com.bosonit.estudianteAsignatura.application.port;

import com.bosonit.estudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;

public interface ReadEstudianteAsignaturaPort {
    EstudianteAsignaturaOutputDTO getAsignaturaByEstudianteID(String id) throws Exception;
}
