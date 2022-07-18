package com.bosonit.BS41Perfiles;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "applicationconfig")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    protected String url;
    protected String password;
}
