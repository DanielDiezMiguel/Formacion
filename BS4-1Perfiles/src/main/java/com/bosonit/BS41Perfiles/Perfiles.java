package com.bosonit.BS41Perfiles;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "perfiles")
public class Perfiles {
    protected String perfil1;
    protected String perfil2;
}
