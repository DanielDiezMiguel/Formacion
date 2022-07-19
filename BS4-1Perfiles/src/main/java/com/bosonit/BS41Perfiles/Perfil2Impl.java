package com.bosonit.BS41Perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil2")
public class Perfil2Impl implements PerfilesInterface {
    @Override
    public void miFuncion() {
        System.out.println("EL valor del perfil 2 es: perfil2");
    }
}
