package com.example.micro_estudiantes.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro_estudiantes.models.entities.Estudiante;
import com.example.micro_estudiantes.models.request.EstudianteRequest;
import com.example.micro_estudiantes.services.EstudianteService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService Service;

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante crear(@Valid @RequestBody EstudianteRequest request){
        return Service.guardar(request);
    }
    
    @GetMapping
    public List<Estudiante> listar(){
        return Service.listarTodos();
    }

    @GetMapping("/{id}")
    public Estudiante buscar(@PathVariable long id){
        return Service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable long id, @Valid @RequestBody EstudianteRequest request) {
        return Service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable long id){
        Service.eliminar(id);
    }
}