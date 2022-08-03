package com.bosonit.estudiante.application.port;

import com.bosonit.estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.estudiante.infrastructure.controller.dto.output.StudentOutputDTO;

public interface UpdateStudentPort {
    StudentOutputDTO updateByID(StudentInputDTO studentInputDTO, String id) throws Exception;
}
