package com.example.micro_estudiantes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro_estudiantes.models.entities.Apoderado;
import com.example.micro_estudiantes.models.request.ApoderadoRequest;
import com.example.micro_estudiantes.services.ApoderadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/apoderados")
public class ApoderadoController {

    @Autowired
    private ApoderadoService service;

    @GetMapping
    public List<Apoderado> listar(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Apoderado obtenerPorId(@PathVariable Long id){ 
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Apoderado crear(@Valid @RequestBody ApoderadoRequest request){
        return service.guardar(request);
    }
    
    @PutMapping("/{id}") 
    public Apoderado editar(@PathVariable Long id, @Valid @RequestBody ApoderadoRequest request){
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }
}