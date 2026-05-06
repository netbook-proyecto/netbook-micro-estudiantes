package com.example.micro_estudiantes.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.micro_estudiantes.dto.EstudianteRequest;
import com.example.micro_estudiantes.model.Estudiante;
import com.example.micro_estudiantes.repositorios.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante guardar(EstudianteRequest request){
        if (estudianteRepository.findByRut(request.getRut()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El RUT estudiante ya existe");
        


        }
        //crear
        Estudiante estudiante = new Estudiante();
        estudiante.setRut(request.getRut());
        estudiante.setNombres(request.getNombres());
        estudiante.setApellidoPaterno(request.getApellidoPaterno());
        estudiante.setApellidoMaterno(request.getApellidoMaterno());
        estudiante.setCorreoInstitucional(request.getCorreoInstitucional());
        estudiante.setFechaNacimiento(request.getFechaNacimiento());
        estudiante.setTelefonoEmergencia(request.getTelefonoEmergencia());
        
        estudiante.setPorcentajeAsistencia(0.0);
        estudiante.setPromedioNotas(0.0);
        return estudianteRepository.save(estudiante);
    }
    //listar todos
    public List<Estudiante>listarTodos(){
        return estudianteRepository.findAll();

    }
    //buscar por id
    public Estudiante buscarPorId(Long id){
        return estudianteRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El estudiante no existe"+ id));
    }
    //actualizar
    public Estudiante actualizar(Long id, EstudianteRequest request){
        Estudiante estudiante = buscarPorId(id);

        estudiante.setNombres(request.getNombres());
        estudiante.setApellidoPaterno(request.getApellidoPaterno());
        estudiante.setApellidoMaterno(request.getApellidoMaterno());
        estudiante.setCorreoInstitucional(request.getCorreoInstitucional());
        estudiante.setFechaNacimiento(request.getFechaNacimiento());
        estudiante.setTelefonoEmergencia(request.getTelefonoEmergencia());

        return estudianteRepository.save(estudiante);
    }
    //eliminar
    public void eliminar(Long id){
        Estudiante estudiante = buscarPorId(id);
        estudianteRepository.delete(estudiante);
    }
}
