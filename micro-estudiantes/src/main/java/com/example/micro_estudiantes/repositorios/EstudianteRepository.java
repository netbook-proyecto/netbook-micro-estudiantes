package com.example.micro_estudiantes.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.micro_estudiantes.model.Estudiante;


public interface EstudianteRepository  extends JpaRepository<Estudiante, Long>{
    Optional<Estudiante> findByRut(String rut);
    
}
