package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.ReadPersonaPort;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
@RequestMapping("persona")
public class ReadPersonaController {

    public static final String GREATER_THAN = "greater";
    public static final String LESS_THAN = "less";
    public static final String EQUAL = "equal";
    @Autowired
    ReadPersonaPort readPersonaPort;


    @GetMapping("/id/{id}")
    public PersonaOutputDTO getUsuarioByID(@PathVariable(value = "id") String id, @RequestParam(defaultValue = "persona", required = false) String outputType) throws Exception {
        return readPersonaPort.getPersonaByID(id, outputType);
    }

    @GetMapping("all/all")
    public List<PersonaOutputDTO> getAllUsuarios(@RequestParam(defaultValue = "persona", required = false) String outputType) {
        return readPersonaPort.getAllUsuarios(outputType);
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaOutputDTO> getUsuarioByName(@PathVariable(value = "nombre") String nombre, @RequestParam(defaultValue = "persona", required = false) String outputType) {
        return readPersonaPort.getPersonaByName(nombre, outputType);
    }

    @GetMapping("/getQuery")
    public List<PersonaOutputDTO> getQueryOrderByField(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "surname", required = false) String surname, @RequestParam(name = "company_email", required = false) String company_email, @RequestParam(name = "id_student") String id_student) throws Exception {
        HashMap<String, Object> data = new HashMap<>();

        if (name != null) data.put("name", name);
        if (surname != null) data.put("surname", surname);
        if (company_email != null) data.put("company_email", company_email);
        if (id_student != null) data.put("id_student", id_student);

        return readPersonaPort.getDataOrderByField(data);
    }
}