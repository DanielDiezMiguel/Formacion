package com.bosonit.Persona.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CustomError {
    private Date timestamp;
    private int httpCode;
    private String message;
}
