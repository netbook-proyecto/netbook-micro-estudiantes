package com.example.micro_estudiantes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.micro_estudiantes.models.entities.Matricula;
import com.example.micro_estudiantes.models.request.MatriculaRequest;
import com.example.micro_estudiantes.services.MatriculaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/matriculas")

public class MatriculaController {
    
    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Matricula crear (@Valid @RequestBody MatriculaRequest request) {
    return matriculaService.guardar(request);
    }
    @GetMapping
    public List<Matricula> listar() {
        return matriculaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Matricula buscarPorId(@PathVariable Long id) {
        return matriculaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Matricula actualizar(@PathVariable Long id, @Valid @RequestBody MatriculaRequest request) {
        return matriculaService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        matriculaService.eliminar(id);
    }
}
