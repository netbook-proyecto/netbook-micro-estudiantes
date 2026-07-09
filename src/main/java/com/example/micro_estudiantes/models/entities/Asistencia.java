package com.example.micro_estudiantes.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "asistencia")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Long idAsistencia;

    @Column(name = "id_estudiante", nullable = false)
    private Long idEstudiante;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "presente", nullable = false)
    private Boolean presente;

    @Column(name = "observacion")
    private String observacion;
}
