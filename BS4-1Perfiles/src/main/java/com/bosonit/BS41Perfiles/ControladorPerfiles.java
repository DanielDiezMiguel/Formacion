package com.bosonit.BS41Perfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPerfiles {

    @Autowired
    @Qualifier("perfilBean1")
    PerfilesInterface perfilesInterface1;

    @Autowired
    @Qualifier("perfilBean2")
    PerfilesInterface perfilesInterface2;


    @GetMapping("/perfil")
    public void getValorPerfil1(){
       perfilesInterface1.miFuncion("Perfil 1");
    }


    @GetMapping("/perfil")
    public void getValorPerfil2(){
        perfilesInterface2.miFuncion("Perfil 2");
    }
}
