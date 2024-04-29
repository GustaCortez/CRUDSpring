package com.students.crud.service;

import com.students.crud.entity.Estudiante;
import com.students.crud.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Servicio
@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante buscarEstudiantePorId(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    public List<Estudiante> buscarEstudiantePorNombre(String nombre) {
        return estudianteRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Estudiante agregarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Estudiante modificarEstudiante(Long id, Estudiante estudiante) {
        Estudiante estudianteExistente = buscarEstudiantePorId(id);
        if (estudianteExistente != null) {
            estudianteExistente.setNombre(estudiante.getNombre());
            estudianteExistente.setApellido(estudiante.getApellido());
            estudianteExistente.setFechaNacimiento(estudiante.getFechaNacimiento());
            estudianteExistente.setCiclo(estudiante.getCiclo());
            estudianteExistente.setCarrera(estudiante.getCarrera());
            return estudianteRepository.save(estudianteExistente);
        }
        return null;
    }

    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }
}
