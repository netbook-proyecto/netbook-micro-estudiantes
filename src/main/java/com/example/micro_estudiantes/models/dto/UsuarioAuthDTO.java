package com.example.micro_estudiantes.models.dto;

import lombok.Data;

@Data
public class UsuarioAuthDTO {
    private String correoInstitucional;
    private String contrasenia;
    private String rol;
    
}
