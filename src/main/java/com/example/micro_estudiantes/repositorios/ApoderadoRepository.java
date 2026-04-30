package com.example.micro_estudiantes.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.micro_estudiantes.model.Apoderado;

public interface ApoderadoRepository extends JpaRepository<Apoderado, Long> {
    
}
