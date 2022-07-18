package com.bosonit.BS41Perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class Perfil1Impl implements PerfilesInterface{
    @Override
    public String miFuncion() {
        return "Texto del perfil 2";
    }
}
