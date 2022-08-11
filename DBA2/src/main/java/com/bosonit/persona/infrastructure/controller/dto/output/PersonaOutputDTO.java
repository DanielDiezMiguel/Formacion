package com.bosonit.persona.infrastructure.controller.dto.output;

import com.bosonit.persona.domain.Persona;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonaOutputDTO implements Serializable {
    private int _id;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public PersonaOutputDTO(Persona persona) {
        if (persona == null) return;
        _id = persona.get_id();
        usuario = persona.getUsuario();
        password = persona.getPassword();
        name = persona.getName();
        surname = persona.getSurname();
        company_email = persona.getCompany_email();
        personal_email = persona.getPersonal_email();
        city = persona.getCity();
        active = persona.getActive();
        created_date = persona.getCreated_date();
        imagen_url = persona.getImagen_url();
        termination_date = persona.getTermination_date();
    }


}
