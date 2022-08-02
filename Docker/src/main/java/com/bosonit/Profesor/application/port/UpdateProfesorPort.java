package com.bosonit.Profesor.application.port;

import com.bosonit.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.bosonit.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;

public interface UpdateProfesorPort {
    ProfesorOutputDTO updateProfesor(String id, ProfesorInputDTO profesorInputDTO) throws Exception;
}
