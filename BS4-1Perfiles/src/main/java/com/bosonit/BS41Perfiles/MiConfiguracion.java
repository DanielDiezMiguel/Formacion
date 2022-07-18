package com.bosonit.BS41Perfiles;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "miconfiguracion")
@PropertySource("classpath:miconfiguracion.properties")
public class MiConfiguracion {

    protected String valor1;
    protected String valor2;

}
