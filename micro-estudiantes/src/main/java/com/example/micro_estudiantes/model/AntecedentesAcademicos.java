package com.example.micro_estudiantes.model;

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
@Table(name = "antecedentes_academicos")
@Data
public class AntecedentesAcademicos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntecedentesAcademicos;

    @Column(nullable = false)
    private String colegioProcedencia;

    @Column(nullable = false)
    private Integer annoEgresoAnterior;

    @Column(nullable = false)
    private Double promedioGeneralAnterior;

    @Column(nullable = false)
    private String observacionesConductualesPr;

    @ManyToOne
    @JoinColumn(name = "id_hoja_vida", nullable = false)
    private HojaVIdaEstudiante hojavida;

}
