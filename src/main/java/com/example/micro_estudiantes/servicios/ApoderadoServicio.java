package com.example.micro_estudiantes.servicios;

import com.example.micro_estudiantes.dto.ApoderadoDTO;
import com.example.micro_estudiantes.model.Apoderado;
import com.example.micro_estudiantes.repositorios.ApoderadoRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApoderadoServicio {

    @Autowired
    private ApoderadoRepository repo;

    // LISTAR TODOS
    public List<ApoderadoDTO> obtenerTodos() {
        return repo.findAll().stream().map(a -> {
            ApoderadoDTO dto = new ApoderadoDTO();
            dto.setId(a.getId());
            dto.setRut(a.getRut());
            dto.setNombres(a.getNombres());
            dto.setApellidos(a.getApellidos());
            dto.setTelefono(a.getTelefono());
            dto.setParentesco(a.getParentesco());
            return dto;
        }).collect(Collectors.toList());
    }

    // GUARDAR
    public ApoderadoDTO guardar(ApoderadoDTO dto) {
        Apoderado a = new Apoderado();
        a.setRut(dto.getRut());
        a.setNombres(dto.getNombres());
        a.setApellidos(dto.getApellidos());
        a.setTelefono(dto.getTelefono());
        a.setParentesco(dto.getParentesco());
        
        Apoderado guardado = repo.save(a);
        dto.setId(guardado.getId());
        return dto;
    }
    // BUSCAR POR ID
    public ApoderadoDTO obtenerPorId(Long id) {
        Apoderado a = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Apoderado no encontrado"));
            
        ApoderadoDTO dto = new ApoderadoDTO();
        dto.setId(a.getId());
        dto.setRut(a.getRut());
        dto.setNombres(a.getNombres());
        dto.setApellidos(a.getApellidos());
        dto.setTelefono(a.getTelefono());
        dto.setParentesco(a.getParentesco());
        return dto;
    }

    // ACTUALIZAR
    public ApoderadoDTO actualizar(Long id, ApoderadoDTO dto) {
        Apoderado a = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Apoderado no encontrado"));
        
        a.setNombres(dto.getNombres());
        a.setApellidos(dto.getApellidos());
        a.setTelefono(dto.getTelefono());
        a.setParentesco(dto.getParentesco());
        
        repo.save(a);
        dto.setId(a.getId());
        return dto;
    }

    // ELIMINAR
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("El apoderado no existe");
        }
        repo.deleteById(id);
    }
}