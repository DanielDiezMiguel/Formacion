package com.bosonit.persona.infrastructure.controller.dto.input;

import lombok.Data;

import java.util.Date;

@Data
public class PersonaInputDTO {
    private String id_persona;
    private String username;
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
    private boolean admin;
}
