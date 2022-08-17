package com.bosonit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class PersonaEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    public PersonaEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PersonaEntity(String name) {
        this.name = name;
    }

    public PersonaEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}