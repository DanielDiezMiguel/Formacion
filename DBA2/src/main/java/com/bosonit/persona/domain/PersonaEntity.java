package com.bosonit.persona.domain;

import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "personas")
public class PersonaEntity {
    @Id
    private String id_persona;
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

    public PersonaEntity(PersonaInputDTO personaInputDTO) {
        if (personaInputDTO == null) return;
        id_persona = personaInputDTO.getId_persona();
        usuario = personaInputDTO.getUsuario();
        password = personaInputDTO.getPassword();
        name = personaInputDTO.getName();
        surname = personaInputDTO.getSurname();
        company_email = personaInputDTO.getCompany_email();
        personal_email = personaInputDTO.getPersonal_email();
        city = personaInputDTO.getCity();
        active = personaInputDTO.getActive();
        created_date = personaInputDTO.getCreated_date();
        imagen_url = personaInputDTO.getImagen_url();
        termination_date = personaInputDTO.getTermination_date();
    }

    public void update(PersonaInputDTO personaInputDTO) {
        if (personaInputDTO == null) return;
        id_persona = personaInputDTO.getId_persona();
        usuario = personaInputDTO.getUsuario();
        password = personaInputDTO.getPassword();
        name = personaInputDTO.getName();
        surname = personaInputDTO.getSurname();
        company_email = personaInputDTO.getCompany_email();
        personal_email = personaInputDTO.getPersonal_email();
        city = personaInputDTO.getCity();
        active = personaInputDTO.getActive();
        created_date = personaInputDTO.getCreated_date();
        imagen_url = personaInputDTO.getImagen_url();
        termination_date = personaInputDTO.getTermination_date();
    }
}
