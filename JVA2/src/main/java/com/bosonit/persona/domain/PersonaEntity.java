package com.bosonit.persona.domain;

import com.bosonit.persona.infrastructure.controller.dto.PersonaInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Persona")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Persona")
    private Integer id_persona;

    @Column(name = "Usuario", nullable = false)
    private String usuario;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Nombre", nullable = false)
    private String name;

    @Column(name = "Surname", nullable = false)
    private String surname;
    @Column(name = "Company_email", nullable = false)
    private String company_email;

    @Column(name = "Personal_email", nullable = false)
    private String personal_email;

    @Column(name = "Ciudad", nullable = false)
    private String city;

    @Column(name = "Activo", nullable = false)
    private Boolean active;

    @Column(name = "Created_Date", nullable = false)
    private Date created_date;

    @Column(name = "Imagen_URL")
    private String imagen_url;

    @Column(name = "Date")
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
