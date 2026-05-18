package com.example.micro_estudiantes.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ApoderadoRequest {

    @NotBlank(message = "El RUT es obligatorio")
    @Size(min = 9, max = 12)
    private String rut;
    
    @NotBlank(message = "Los nombres son obligatorios")
    private String nombres;
    
    @NotBlank(message = "El apellido paterno es obligatorio") 
    private String apellidoPaterno;
    
    @NotBlank(message = "El apellido materno es obligatorio") 
    private String apellidoMaterno;
    
    @NotBlank(message = "El correo institucional es obligatorio")
    private String correoInstitucional;
    
    @NotBlank(message = "El parentesco es obligatorio")
    private String parentesco;
    
    @NotBlank(message = "El teléfono de contacto es obligatorio")
    private String telefonoContacto;
    
    @NotBlank(message = "La ocupación es obligatoria")
    private String ocupacion;
}