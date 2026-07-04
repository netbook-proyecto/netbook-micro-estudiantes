package com.example.micro_estudiantes.services;

import com.example.micro_estudiantes.models.entities.Asistencia;
import com.example.micro_estudiantes.models.request.AsistenciaRequest;
import com.example.micro_estudiantes.repositories.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository repository;

    public List<Asistencia> listarTodas() {
        return repository.findAll();
    }

    public List<Asistencia> listarPorEstudiante(Long idEstudiante) {
        return repository.findByIdEstudiante(idEstudiante);
    }

    public Asistencia guardar(AsistenciaRequest request) {
        Asistencia asistencia = new Asistencia();
        asistencia.setIdEstudiante(request.getIdEstudiante());
        asistencia.setFecha(request.getFecha());
        asistencia.setPresente(request.getPresente());
        asistencia.setObservacion(request.getObservacion());
        return repository.save(asistencia);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asistencia no encontrada");
        }
        repository.deleteById(id);
    }
}
