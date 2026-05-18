package com.example.micro_estudiantes.confing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient cursoWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:5004/cursos")
                .build();
    }
}