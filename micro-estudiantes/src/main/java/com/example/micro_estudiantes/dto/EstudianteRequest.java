package com.example.micro_estudiantes.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EstudianteRequest {
    
    @NotBlank(message = "El rut es obligatorio")
    @Size(min = 9, max = 12)
    private String rut;

    @NotBlank(message = "Los nombres son obligatorios")
    private String nombres;

    @NotBlank(message = "Los apellido paterno es obligatorios")
    private String apellidoPaterno;

    @NotBlank(message = "El correo institucional es obligatorio")
    private String apellidoMaterno;
    
    @NotBlank(message = "La fecha de nacimiento es obligatoria")
    @Email(message = "El correo institucional no es valido")
    private String correoInstitucional;

    @NotBlank(message = "La fecha de nacimiento es obligatorio")
    private LocalDate fechaNacimiento;
    
    @NotBlank(message = "El telefono de emergencias es obligatoria")
    private String telefonoEmergencia;
  
}
