package com.example.micro_estudiantes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient academicoWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:5004/cursos")
                .build();
    }
    
    @Bean
    public WebClient authWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:5001")
                .build();
    }
}
//hola
