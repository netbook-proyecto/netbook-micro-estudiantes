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
import com.example.micro_estudiantes.models.dto.UsuarioAuthDTO;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private WebClient academicoWebClient; 

    @Autowired
    private WebClient authWebClient; 

    public Estudiante guardar(EstudianteRequest request){
        if (estudianteRepository.findByRut(request.getRut()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El RUT estudiante ya existe");
        }

        // Validación WebClient Académico
        Integer idCursoBuscado = request.getIdCurso(); 
        if (idCursoBuscado != null) {
            try {
                academicoWebClient.get().uri("/{id}", idCursoBuscado).retrieve().bodyToMono(CursoDTO.class).block(); 
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontramos el curso en Académico");
            }
        }

        // Creación WebClient Auth
    try {
        UsuarioAuthDTO nuevoUsuario = new UsuarioAuthDTO();
        nuevoUsuario.setCorreoInstitucional(request.getCorreoInstitucional());
        nuevoUsuario.setContrasenia("Bernardo2026@"); // Contraseña por defecto

        authWebClient.post()
            .uri("/api/auth/register") // <--- RUTA CORREGIDA (Exacta según el @RequestMapping de Auth)
            .bodyValue(nuevoUsuario)
            .retrieve()
            .toBodilessEntity()
            .block(); 
    } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo crear credencial en Auth: " + e.getMessage());
    }

    // 2. Guardado del estudiante
    Estudiante estudiante = new Estudiante();
    estudiante.setRut(request.getRut());
    estudiante.setNombres(request.getNombres());
    estudiante.setApellidoPaterno(request.getApellidoPaterno());
    estudiante.setApellidoMaterno(request.getApellidoMaterno());
    estudiante.setCorreoInstitucional(request.getCorreoInstitucional());
    estudiante.setFechaNacimiento(request.getFechaNacimiento());
    estudiante.setTelefonoEmergencia(request.getTelefonoEmergencia());
    estudiante.setIdCurso(request.getIdCurso());
    
    return estudianteRepository.save(estudiante);
}
    
    public List<Estudiante> listarTodos(){
        return estudianteRepository.findAll();
    }
    
    public Estudiante buscarPorId(Long id){
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        if (estudiante == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontramos al estudiante");
        }
        return estudiante;
    }
    
    public Estudiante actualizar(Long id, EstudianteRequest request){
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        
        if (estudiante == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontramos al estudiante");
        } else {
            estudiante.setNombres(request.getNombres());
            estudiante.setApellidoPaterno(request.getApellidoPaterno());
            estudiante.setApellidoMaterno(request.getApellidoMaterno());
            estudiante.setCorreoInstitucional(request.getCorreoInstitucional());
            estudiante.setFechaNacimiento(request.getFechaNacimiento());
            estudiante.setTelefonoEmergencia(request.getTelefonoEmergencia());

            return estudianteRepository.save(estudiante);
        }
    }
    
    public void eliminar(Long id){
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        
        if (estudiante == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontramos al estudiante");
        } else {
            estudianteRepository.delete(estudiante);
        }
    }
}