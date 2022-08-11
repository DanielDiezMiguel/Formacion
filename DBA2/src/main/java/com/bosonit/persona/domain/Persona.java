package com.bosonit.persona.domain;

import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "Personas")
public class Persona {
    @Id
    private Integer id_persona;
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

    public Persona(PersonaInputDTO usuarioInputDTO) {
        if (usuarioInputDTO == null) return;
        id_persona = usuarioInputDTO.getId_persona();
        usuario = usuarioInputDTO.getUsuario();
        password = usuarioInputDTO.getPassword();
        name = usuarioInputDTO.getName();
        surname = usuarioInputDTO.getSurname();
        company_email = usuarioInputDTO.getCompany_email();
        personal_email = usuarioInputDTO.getPersonal_email();
        city = usuarioInputDTO.getCity();
        active = usuarioInputDTO.getActive();
        created_date = usuarioInputDTO.getCreated_date();
        imagen_url = usuarioInputDTO.getImagen_url();
        termination_date = usuarioInputDTO.getTermination_date();
    }

    public void update(PersonaInputDTO usuarioInputDTO) {
        if (usuarioInputDTO == null) return;
        id_persona = usuarioInputDTO.getId_persona();
        usuario = usuarioInputDTO.getUsuario();
        password = usuarioInputDTO.getPassword();
        name = usuarioInputDTO.getName();
        surname = usuarioInputDTO.getSurname();
        company_email = usuarioInputDTO.getCompany_email();
        personal_email = usuarioInputDTO.getPersonal_email();
        city = usuarioInputDTO.getCity();
        active = usuarioInputDTO.getActive();
        created_date = usuarioInputDTO.getCreated_date();
        imagen_url = usuarioInputDTO.getImagen_url();
        termination_date = usuarioInputDTO.getTermination_date();
    }
}
