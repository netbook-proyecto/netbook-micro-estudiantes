package com.example.micro_estudiantes.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "estudiantes")
@Data
@EqualsAndHashCode(callSuper = true)
public class Estudiante extends Usuario{

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private String telefonoEmergencia;

    @Column(nullable = false)
    private Double promedioNotas;

    @Column(nullable = false)
    private Double porcentajeAsistencia;

    @Column(name = "id_curso")
    private Integer idCurso;
    


}
