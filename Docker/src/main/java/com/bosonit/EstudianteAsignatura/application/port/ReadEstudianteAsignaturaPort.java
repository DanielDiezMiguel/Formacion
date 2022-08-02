package com.bosonit.EstudianteAsignatura.application.port;

import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;

public interface ReadEstudianteAsignaturaPort {
    EstudianteAsignaturaOutputDTO getAsignaturaByEstudianteID(String id) throws Exception;
}
