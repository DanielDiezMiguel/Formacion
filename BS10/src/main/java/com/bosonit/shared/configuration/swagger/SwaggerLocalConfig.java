package com.bosonit.shared.configuration.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerLocalConfig {

    public OpenAPI openApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Formacion API")
                                .description("API para pruebas de formación")
                                .version("v1.0")
                                .contact(null)
                                .termsOfService("TOC")
                                .license(new License().name("License").url("#")));
    }

    @Bean
    public GroupedOpenApi lowcode() {
        return GroupedOpenApi.builder()
                .group("Formacion")
                .packagesToScan("com.bosonit")
                .build();
    }


}
