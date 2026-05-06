package com.example.micro_estudiantes.model;

import java.time.LocalDate;

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
@Table(name = "hoja_vida_estudiante")
@Data
public class HojaVIdaEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHojaVida;

    @Column(nullable = false)
    private LocalDate fechaAperturaExpediente;

    @Column(nullable = false)
    private String estadoExpediente;

    @OneToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;
}