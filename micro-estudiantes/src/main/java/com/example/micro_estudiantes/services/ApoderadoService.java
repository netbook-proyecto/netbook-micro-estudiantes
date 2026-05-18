package com.example.micro_estudiantes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.micro_estudiantes.models.entities.Apoderado;
import com.example.micro_estudiantes.models.request.ApoderadoRequest;
import com.example.micro_estudiantes.repositories.ApoderadoRepository;

@Service
public class ApoderadoService {
    
    @Autowired
    private ApoderadoRepository repository;

    // listar todos
    public List<Apoderado> listarTodos(){
        return repository.findAll();
    }

    // buscar por ID
    public Apoderado buscarPorId(Long id){
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El apoderado no existe: " + id)); 
    }
    
    // guardar
    public Apoderado guardar(ApoderadoRequest request){ 
        if (repository.findByRut(request.getRut()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El rut apoderado ya existe: " + request.getRut());
        }

        Apoderado apoderado = new Apoderado();
        mapearDatos(apoderado, request); 
        return repository.save(apoderado);
    }

    // actualizar
    public Apoderado actualizar(Long id, ApoderadoRequest request){ 
        Apoderado apoderado = buscarPorId(id);
        mapearDatos(apoderado, request);
        return repository.save(apoderado);
    }

    // eliminar
    public void eliminar(Long id){
        Apoderado apoderado = buscarPorId(id);
        repository.delete(apoderado);
    }

    // mapeador para no repetir código
    private void mapearDatos(Apoderado apoderado, ApoderadoRequest request) {
        apoderado.setRut(request.getRut());
        apoderado.setNombres(request.getNombres());
        apoderado.setApellidoPaterno(request.getApellidoPaterno());
        apoderado.setApellidoMaterno(request.getApellidoMaterno());
        apoderado.setCorreoInstitucional(request.getCorreoInstitucional());
        
        // datos exclusivos del apoderado
        apoderado.setParentesco(request.getParentesco());
        apoderado.setTelefonoContacto(request.getTelefonoContacto());
        apoderado.setOcupacion(request.getOcupacion());
    }
}     