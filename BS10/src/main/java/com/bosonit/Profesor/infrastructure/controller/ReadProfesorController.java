package com.bosonit.Profesor.infrastructure.controller;

import com.bosonit.Profesor.application.port.ReadProfesorPort;
import com.bosonit.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("profesor")
public class ReadProfesorController {

    @Autowired
    ReadProfesorPort readProfesorPort;

    @GetMapping("/id/{id}")
    public ProfesorOutputDTO getProfesorByID(@PathVariable(name = "id") String id) throws Exception {
        System.out.println("llamado a getProfesorByID ");
        return readProfesorPort.getProfesorByID(id);
    }

    @GetMapping("all/all")
    public List<ProfesorOutputDTO> getAllProfesores() {
        return readProfesorPort.getAllProfesores();
    }

    @GetMapping("branch/{branch}")
    public List<ProfesorOutputDTO> getProfesorByBranch(@PathVariable(name = "branch") String branch) {
        return readProfesorPort.getProfesorByBranch(branch);
    }
}
