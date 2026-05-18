package com.example.micro_estudiantes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.reactive.function.client.WebClient; 

import com.example.micro_estudiantes.models.entities.Estudiante;
import com.example.micro_estudiantes.models.request.EstudianteRequest;
import com.example.micro_estudiantes.repositories.EstudianteRepository;
import com.example.micro_estudiantes.models.dto.CursoDTO;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private WebClient cursoWebClient;

    public Estudiante guardar(EstudianteRequest request){
        if (estudianteRepository.findByRut(request.getRut()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El RUT estudiante ya existe");
        }

        // --- INICIO VALIDACIÓN DE MICROSERVICIOS (CONEXIÓN 5002 -> 5004) ---
        Integer idCursoBuscado = request.getIdCurso(); 
        
        if (idCursoBuscado != null) {
            try {
                cursoWebClient.get()
                    .uri("/{id}", idCursoBuscado)
                    .retrieve()
                    .bodyToMono(CursoDTO.class)
                    .block(); 
            } catch (Exception e) {
                e.printStackTrace(); 
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error de Validación: El curso con ID " + idCursoBuscado + " no existe en el sistema Académico.");
            }
        }

        Estudiante estudiante = new Estudiante();
        estudiante.setRut(request.getRut());
        estudiante.setNombres(request.getNombres());
        estudiante.setApellidoPaterno(request.getApellidoPaterno());
        estudiante.setApellidoMaterno(request.getApellidoMaterno());
        estudiante.setCorreoInstitucional(request.getCorreoInstitucional());
        estudiante.setFechaNacimiento(request.getFechaNacimiento());
        estudiante.setTelefonoEmergencia(request.getTelefonoEmergencia());
        
        estudiante.setIdCurso(idCursoBuscado); 
        
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