package com.bailram.restfullapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket apiDocumentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bailram.restfullapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Restfull API Mahasiswa",
                "Making Restfull API using Spring Boot and Swagger for documentation API",
                "v1.0",
                "Term of Service",
                new Contact("Dhimas Bayu Ilham R", "github.com/bailram", "dhimasbayu.9f@gmail.com"),
                "Open Source",
                "https://github.com/bailram/restfullapispringboot",
                Collections.emptyList()
        );
    }
}
