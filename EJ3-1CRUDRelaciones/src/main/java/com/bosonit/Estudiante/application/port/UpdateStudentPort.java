package com.bosonit.Estudiante.application.port;

import com.bosonit.Estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;

public interface UpdateStudentPort {
    StudentOutputDTO updateByID(StudentInputDTO studentInputDTO, String id) throws Exception;
}
