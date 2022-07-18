package com.bosonit.BS41Perfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorApplication {
    @Autowired
    @Qualifier("applicationconfigbean")
    ApplicationConfig applicationConfig;

    @GetMapping("/parametros")
    public String getApplicationValues() {
        return "URL:" + applicationConfig.getUrl() + " PASSWORD:" + applicationConfig.getPassword();
    }
}
