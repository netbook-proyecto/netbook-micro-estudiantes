package com.example.micro_estudiantes.model;

import jakarta.persistence.*; 
import lombok.Data; 

@Entity 
@Table(name = "apoderados")
@Data 
public class Apoderado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String rut;
    
    private String nombres;
    private String apellidos;
    private String telefono;
    private String parentesco;

}