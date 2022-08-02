package com.bosonit.Estudiante.application.port;

import com.bosonit.Estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputFullDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputSimpleDTO;

import java.util.List;

public interface ReadStudentPort {
    StudentOutputDTO getStudentByID(String id, String outType) throws Exception;
    List<StudentOutputDTO> getAllStudents();
    List<StudentOutputDTO> getStudentByBranch(String branch);
}
