package com.bosonit.BS41Perfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorMiConfiguracion {
    @Autowired
    @Qualifier("miconfiguracionbean")
    MiConfiguracion miConfiguracion;

    @GetMapping("/miconfiguracion")
    public String getMiConfiguracionValues() {
        return "Valor1:" + miConfiguracion.getValor1() + " Valor2:" + miConfiguracion.getValor2();
    }
}
