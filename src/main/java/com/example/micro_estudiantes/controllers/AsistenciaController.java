package com.example.micro_estudiantes.controllers;

import com.example.micro_estudiantes.models.entities.Asistencia;
import com.example.micro_estudiantes.models.request.AsistenciaRequest;
import com.example.micro_estudiantes.services.AsistenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {

    @Autowired
    private AsistenciaService service;

    @GetMapping
    public List<Asistencia> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/estudiante/{idEstudiante}")
    public List<Asistencia> listarPorEstudiante(@PathVariable Long idEstudiante) {
        return service.listarPorEstudiante(idEstudiante);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Asistencia registrar(@Valid @RequestBody AsistenciaRequest request) {
        return service.guardar(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}