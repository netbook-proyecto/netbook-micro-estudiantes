package com.example.micro_estudiantes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.micro_estudiantes.dto.ApoderadoDTO;
import com.example.micro_estudiantes.servicios.ApoderadoServicio;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/apoderados")
public class ApoderadoControlador {
    
    @Autowired
    private ApoderadoServicio servicio;

    @PostMapping
    @Operation(summary = "Crear un apoderado nuevo")
    public ResponseEntity<ApoderadoDTO> guardar(@RequestBody ApoderadoDTO dto) {
        return ResponseEntity.ok(servicio.guardar(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos los apoderados")
    public ResponseEntity<List<ApoderadoDTO>> listar() {
        return ResponseEntity.ok(servicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener apoderado por ID")
    public ResponseEntity<ApoderadoDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servicio.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar datos de un apoderado")
    public ResponseEntity<ApoderadoDTO> actualizar(@PathVariable Long id, @RequestBody ApoderadoDTO dto) {
        return ResponseEntity.ok(servicio.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un apoderado")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}