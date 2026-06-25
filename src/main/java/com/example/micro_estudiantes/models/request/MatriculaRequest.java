package com.example.micro_estudiantes.models.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MatriculaRequest {

    @NotNull(message = "La fecha de matricula es obligatoria")
    private LocalDate fechaMatricula;

    @NotNull(message = "El año académico es obligatorio")
    private Integer annoAcademico;

    @NotNull(message = "El estado de la matrícula es obligatorio")
    private String estadoMatricula;
    
    @NotNull(message = "El tipo de matrícula es obligatorio")
    private String tipoMatricula;

    @NotNull(message = "El ID del estudiante es obligatorio")
    private Long idEstudiante;

    @NotNull(message = "El ID del apoderado es obligatorio")
    private Long idApoderado;
}
