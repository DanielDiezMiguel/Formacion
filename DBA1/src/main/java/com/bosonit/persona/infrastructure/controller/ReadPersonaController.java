package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.ReadPersonaPort;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public List<PersonaOutputDTO> getQuery(@RequestParam(name = "usuario", required = false) String usuario, @RequestParam(name = "name", required = false) String name, @RequestParam(name = "surname", required = false) String surname, @RequestParam(name = "created_date", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date created_date, @RequestParam(name = "dateCondition", required = false) String dateCondition) {
        HashMap<String, Object> data = new HashMap<>();

        if (usuario != null) data.put("usuario", usuario);
        if (name != null) data.put("name", name);
        if (surname != null) data.put("surname", surname);
        if (created_date != null) data.put("created_date", created_date);
        if (dateCondition == null) dateCondition = GREATER_THAN;
        if (dateCondition.equals(GREATER_THAN)) dateCondition = GREATER_THAN;
        else if (dateCondition.equals(LESS_THAN)) dateCondition = LESS_THAN;
        else if (dateCondition.equals(EQUAL)) dateCondition = EQUAL;
        if (dateCondition != null) data.put("dateCondition", dateCondition);

        return readPersonaPort.getData(data);

    }
}
