package com.students.crud.controller;

import com.students.crud.entity.Estudiante;
import com.students.crud.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> listarEstudiantes() {
        return estudianteService.listarEstudiantes();
    }

    @GetMapping("/{id}")
    public Estudiante buscarEstudiantePorId(@PathVariable Long id) {
        return estudianteService.buscarEstudiantePorId(id);
    }

    @GetMapping("/buscar")
    public List<Estudiante> buscarEstudiantePorNombre(@RequestParam String nombre) {
        return estudianteService.buscarEstudiantePorNombre(nombre);
    }

    @PostMapping
    public Estudiante agregarEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.agregarEstudiante(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiante modificarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        return estudianteService.modificarEstudiante(id, estudiante);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
    }
}