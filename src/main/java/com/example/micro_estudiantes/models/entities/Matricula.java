package com.example.micro_estudiantes.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "matriculas")
@Data
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatricula;
    
    @Column(nullable = false)
    private LocalDate fechaMatricula;
    
    @Column(nullable = false)
    private Integer annoAcademico;
    
    @Column(nullable = false)
    private String estadoMatricula;
    
    @Column(nullable = false)
    private String tipoMatricula;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;
    
    @ManyToOne
    @JoinColumn(name = "id_apoderado", nullable = false)
    private Apoderado apoderado;

    
}
