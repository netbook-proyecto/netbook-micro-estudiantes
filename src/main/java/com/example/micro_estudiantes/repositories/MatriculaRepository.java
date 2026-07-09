package com.example.micro_estudiantes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.micro_estudiantes.models.entities.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    
}
