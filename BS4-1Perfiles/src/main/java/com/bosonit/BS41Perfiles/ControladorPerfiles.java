package com.bosonit.BS41Perfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPerfiles {

    @Autowired()
    @Qualifier("perfilBean1")
    PerfilesInterface perfilesInterface1;

    @Autowired()
    @Qualifier("perfilBean2")
    PerfilesInterface perfilesInterface2;

    @GetMapping("/perfil")
    public String getValorPerfil1(){
       return perfilesInterface1.miFuncion();
    }

    @GetMapping("/perfil")
    public String getValorPerfil2(){
        return perfilesInterface2.miFuncion();
    }
}
