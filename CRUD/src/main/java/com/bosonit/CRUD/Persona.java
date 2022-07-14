package com.bosonit.CRUD;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    protected int id;
    protected String nombre;
    protected int edad;
    protected String población;
}
