package com.bosonit.BS4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {

    @Autowired
    ConfigurationProperties configurationProperties;

    @RequestMapping(value = "/valores", method = RequestMethod.GET)
    public String getVaules() {
        return "valor de var1 es:" + configurationProperties.getVar1() + " valor de var2 es: " + configurationProperties.getVar2();
    }

    @RequestMapping(value = "/var3", method = RequestMethod.GET)
    public String getValueVar3() {
        //configurationProperties.setVar3("var3 no tiene valor");
        return "valor de var3 es: " + configurationProperties.getVar3();
    }
}
