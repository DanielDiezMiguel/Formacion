package com.bosonit.BS41Perfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPerfiles {

    @Autowired
    PerfilesInterface perfilesInterface1;

    @GetMapping("/perfil")
    public void getValorPerfil1(){
       perfilesInterface1.miFuncion();
    }
}
