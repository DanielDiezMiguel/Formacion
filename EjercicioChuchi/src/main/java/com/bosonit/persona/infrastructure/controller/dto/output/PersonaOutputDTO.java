package com.bosonit.persona.infrastructure.controller.dto.output;

import com.bosonit.persona.domain.PersonaEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonaOutputDTO implements Serializable {
    private String id_persona;
    private String id_student;
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

    public PersonaOutputDTO(PersonaEntity personaEntity) {
        if (personaEntity == null) return;
        id_persona = personaEntity.getId_persona();
        id_student = personaEntity.getStudentEntity().getId_student();
        usuario = personaEntity.getUsuario();
        password = personaEntity.getPassword();
        name = personaEntity.getName();
        surname = personaEntity.getSurname();
        company_email = personaEntity.getCompany_email();
        personal_email = personaEntity.getPersonal_email();
        city = personaEntity.getCity();
        active = personaEntity.getActive();
        created_date = personaEntity.getCreated_date();
        imagen_url = personaEntity.getImagen_url();
        termination_date = personaEntity.getTermination_date();
    }


}
