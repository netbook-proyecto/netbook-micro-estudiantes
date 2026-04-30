package com.example.micro_estudiantes.controladores;

import com.example.micro_estudiantes.dto.EstudianteDTO;
import com.example.micro_estudiantes.servicios.EstudianteServicio;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio servicio;

    @PostMapping
    @Operation(summary = "Crear un estudiante nuevo")
    public ResponseEntity<EstudianteDTO> guardar(@RequestBody EstudianteDTO dto) {
        return ResponseEntity.ok(servicio.guardar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar datos del alumno")
    public ResponseEntity<EstudianteDTO> actualizar(@PathVariable Long id, @RequestBody EstudianteDTO dto) {
        return ResponseEntity.ok(servicio.actualizar(id, dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar alumno por id")
    public ResponseEntity<EstudianteDTO> buscar(@PathVariable Long id) {
        // Cambiado de buscarPorId a obtenerPorId para que calce con tu Servicio
        return ResponseEntity.ok(servicio.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar un alumno")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}