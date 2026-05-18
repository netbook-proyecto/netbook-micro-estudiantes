package com.example.micro_estudiantes.models.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EstudianteRequest {
    
    @NotBlank(message = "El rut es obligatorio")
    @Size(min = 9, max = 12)
    private String rut;

    @NotBlank(message = "Los nombres son obligatorios")
    private String nombres;

    @NotBlank(message = "El apellido paterno es obligatorio")
    private String apellidoPaterno;

    @NotBlank(message = "El apellido materno es obligatorio")
    private String apellidoMaterno;
    
    @NotBlank(message = "El correo institucional es obligatorio") 
    @Email(message = "El correo institucional no es valido")
    private String correoInstitucional;

    @NotNull(message = "La fecha de nacimiento es obligatoria") 
    private LocalDate fechaNacimiento;
    
    @NotBlank(message = "El telefono de emergencia es obligatorio")
    private String telefonoEmergencia;

    @NotNull(message = "El ID del curso es obligatorio para matricular al estudiante")
    private Integer idCurso;
  
}