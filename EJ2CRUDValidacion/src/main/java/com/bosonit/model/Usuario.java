package com.bosonit.model;

import com.bosonit.dto.UsuarioDTO;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Persona")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Persona")
    private Integer id_persona;

    @NonNull
    @Column(name = "Usuario")
    private String usuario;

    @NonNull
    @Column(name = "Password")
    private String password;

    @NonNull
    @Column(name = "Nombre")
    private String name;

    @NonNull
    @Column(name = "Surname")
    private String surname;

    @NonNull
    @Column(name = "Company_email")
    private String company_email;

    @NonNull
    @Column(name = "Personal_email")
    private String persona_email;

    @NonNull
    @Column(name = "Ciudad")
    private String city;

    @NonNull
    @Column(name = "Activo")
    private Boolean active;

    @NonNull
    @Column(name = "Created_Date")
    private Date created_date;

    @Column(name = "Imagen_URL")
    private String imagen_url;

    @Column(name = "Date")
    private Date termination_date;

    public Usuario (UsuarioDTO usuarioDTO) {
        if (id_persona == null) return;
        id_persona = usuarioDTO.getId_persona();
        usuario = usuarioDTO.getUsuario();
        surname = usuarioDTO.getSurname();
        company_email = usuarioDTO.getCompany_email();
        persona_email = usuarioDTO.getPersona_email();
        city = usuarioDTO.getCity();
        active = usuarioDTO.getActive();
        created_date = usuarioDTO.getCreated_date();
        imagen_url = usuarioDTO.getImagen_url();
        termination_date = usuarioDTO.getTermination_date();
    }
}
