package com.example.movieservice;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Movie Service API")
                        .description("API for Movie Service ")
                        .version("1.0")
                        .contact(new Contact()
                                .name("s25067")
                                .email("s25067@pjwstk.edu.pl")));
    }
}
