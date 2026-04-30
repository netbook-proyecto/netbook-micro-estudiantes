package com.example.micro_estudiantes.dto;

import lombok.Data;

@Data
public class ApoderadoDTO {
    private Long id;
    private String rut;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String parentesco;
}