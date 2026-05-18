package com.example.micro_estudiantes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.micro_estudiantes.models.entities.Estudiante;


public interface EstudianteRepository  extends JpaRepository<Estudiante, Long>{
    Optional<Estudiante> findByRut(String rut);
    
}
