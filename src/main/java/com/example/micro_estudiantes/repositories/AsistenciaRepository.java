package com.example.micro_estudiantes.repositories;

import com.example.micro_estudiantes.models.entities.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
    List<Asistencia> findByIdEstudiante(Long idEstudiante);
}
