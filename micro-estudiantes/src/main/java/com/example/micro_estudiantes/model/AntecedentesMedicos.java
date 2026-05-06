package com.example.micro_estudiantes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "antecedentes_medicos")
@Data
public class AntecedentesMedicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntecedentesMedicos; 
    @Column(nullable = false)
    private String grupoSanguineo;
   
    @Column(nullable = false)
    private String alergiasConocidas;
   
    @Column(nullable = false)
    private String condicionesCronicasMedicas;
   
    @Column(nullable = false)
    private String medicamentosRegulares; 
   
    @Column(nullable = false)
    private String indicacionesEmergencia;

    @OneToOne
    @JoinColumn(name = "id_hoja_vida", nullable = false)
    private HojaVIdaEstudiante hojaVida; }

