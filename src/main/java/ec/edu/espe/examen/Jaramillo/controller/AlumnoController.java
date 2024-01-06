package ec.edu.espe.examen.Jaramillo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.Jaramillo.domain.Alumno;
import ec.edu.espe.examen.Jaramillo.service.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    private AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Alumno> save(@RequestBody Alumno alumno) {
        return ResponseEntity.ok().body(this.alumnoService.crearAlumno(alumno));
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Alumno>> findAll() {
        return ResponseEntity.ok().body(this.alumnoService.findAll());
    }
}
