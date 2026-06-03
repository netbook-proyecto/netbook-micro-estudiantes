package com.example.micro_estudiantes.confing;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server; // <-- 1. Nueva importación para el Servidor
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI netbookOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Estudiantes y Apoderados - netBOOK")
                        .description("Microservicio central para la administración del directorio demográfico de la plataforma escolar. Construido bajo arquitectura de capas con validaciones DTO y persistencia en MySQL.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Cristopher Candia")
                                .email("cr.candiam@duocuc.cl")))
                .addServersItem(new Server()
                        .url("http://localhost:5002/swagger-ui/index.html")
                        .description("Servidor Local (Microservicio Estudiantes)")); 
    }
}