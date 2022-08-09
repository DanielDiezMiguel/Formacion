package com.bosonit.estudiante.application.port;

import com.bosonit.estudiante.infrastructure.controller.dto.output.StudentOutputDTO;

import java.util.List;

public interface ReadStudentPort {
    StudentOutputDTO getStudentByID(String id, String outType) throws Exception;
    List<StudentOutputDTO> getAllStudents();
    List<StudentOutputDTO> getStudentByBranch(String branch);
}
