package com.bosonit.BS41Perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil1")
public class Perfil1Impl implements PerfilesInterface{
    @Override
    public void miFuncion() {
        System.out.println("El valor del perfil 1 es: perfil1");
    }

}
