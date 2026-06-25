package com.example.micro_estudiantes.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.micro_estudiantes.models.entities.Apoderado;
import com.example.micro_estudiantes.models.entities.Estudiante;
import com.example.micro_estudiantes.models.entities.Matricula;
import com.example.micro_estudiantes.models.request.MatriculaRequest;
import com.example.micro_estudiantes.repositories.ApoderadoRepository;
import com.example.micro_estudiantes.repositories.EstudianteRepository;
import com.example.micro_estudiantes.repositories.MatriculaRepository;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ApoderadoRepository apoderadoRepository;

    public Matricula guardar(MatriculaRequest request) {
        Estudiante estudiante = estudianteRepository.findById(request.getIdEstudiante())
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se encontró el estudiante con ID: " + request.getIdEstudiante()));

        Apoderado apoderado = apoderadoRepository.findById(request.getIdApoderado())
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se encontró el apoderado con ID: " + request.getIdApoderado()));

        Matricula matricula = new Matricula();
        matricula.setFechaMatricula(request.getFechaMatricula());
        matricula.setAnnoAcademico(request.getAnnoAcademico());
        matricula.setEstadoMatricula(request.getEstadoMatricula());
        matricula.setTipoMatricula(request.getTipoMatricula());
        matricula.setEstudiante(estudiante);
        matricula.setApoderado(apoderado);

        return matriculaRepository.save(matricula);
    }

    public List<Matricula> listarTodos() {
        return matriculaRepository.findAll();
    }

    public Matricula buscarPorId(Long id) {
        return matriculaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se encontró la matrícula con ese ID: " + id));
    }

    public Matricula actualizar(Long id, MatriculaRequest request) {
        Matricula matricula = buscarPorId(id);   
        matricula.setAnnoAcademico(request.getAnnoAcademico());
        matricula.setEstadoMatricula(request.getEstadoMatricula());
        matricula.setTipoMatricula(request.getTipoMatricula());
        return matriculaRepository.save(matricula);
    }

    public void eliminar(Long id) {
        Matricula matricula = buscarPorId(id);
        matriculaRepository.delete(matricula);
    }
}