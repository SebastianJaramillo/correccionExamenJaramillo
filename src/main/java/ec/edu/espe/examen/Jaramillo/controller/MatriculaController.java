package ec.edu.espe.examen.Jaramillo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.Jaramillo.domain.AlumnoAsignatura;
import ec.edu.espe.examen.Jaramillo.service.MatriculaService;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    private MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping("/asignar")
    public ResponseEntity<AlumnoAsignatura> asignarAlumnoAsignatura(@RequestBody AlumnoAsignatura alumnoAsignatura) {
        return ResponseEntity.ok().body(this.matriculaService.asignarAlumnoAsignatura(alumnoAsignatura));
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<AlumnoAsignatura>> findAll() {
        return ResponseEntity.ok().body(this.matriculaService.findAll());
    }

    @GetMapping("/alumno/{codAlumno}")
    public ResponseEntity<List<AlumnoAsignatura>> findByAlumno(@PathVariable Long codAlumno) {
        return ResponseEntity.ok().body(this.matriculaService.findByAlumno(codAlumno));
    }
}
