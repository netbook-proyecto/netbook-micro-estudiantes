package com.example.micro_estudiantes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "apoderados")
@Data
@EqualsAndHashCode(callSuper = true)
public class Apoderado extends Usuario {
    
    @Column(nullable = false)
    private String telefonoContacto;
    
    @Column(nullable = false)
    private String ocupacion;
}
