package com.example.micro_estudiantes.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.micro_estudiantes.dto.EstudianteDTO;
import com.example.micro_estudiantes.model.Estudiante;
import com.example.micro_estudiantes.repositorios.EstudianteRepository;

@Service
public class EstudianteServicio {

    @Autowired
    private EstudianteRepository repo; // Corregido el nombre de la variable

    // 1. GUARDAR
    public EstudianteDTO guardar(EstudianteDTO dto){
        Estudiante e = new Estudiante();
        e.setRut(dto.getRut());
        e.setNombres(dto.getNombres());
        e.setApellidos(dto.getApellidos());
        
        Estudiante guardado = repo.save(e);
        
        dto.setId(guardado.getId());
        return dto;
    }

    // 2. Buscar por ID)
    public EstudianteDTO obtenerPorId(Long id){
        Estudiante e = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
            
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(e.getId());
        dto.setRut(e.getRut());
        dto.setNombres(e.getNombres());
        dto.setApellidos(e.getApellidos());
        return dto;
    }

    // 3. ACTUALIZAR
    public EstudianteDTO actualizar(Long id, EstudianteDTO dto){
        Estudiante e = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
            
        e.setRut(dto.getRut());
        e.setNombres(dto.getNombres());
        e.setApellidos(dto.getApellidos());
        
        repo.save(e);
        
        dto.setId(e.getId());
        return dto;
    }
    
    // 4. ELIMINAR
    public void eliminar(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("No se puede eliminar: Estudiante no encontrado");
        }
        repo.deleteById(id);
    }
}