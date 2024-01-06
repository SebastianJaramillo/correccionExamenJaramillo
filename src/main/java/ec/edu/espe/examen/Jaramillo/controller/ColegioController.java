package ec.edu.espe.examen.Jaramillo.controller;

import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.Jaramillo.domain.Colegio;
import ec.edu.espe.examen.Jaramillo.service.ColegioService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/colegio")
public class ColegioController {

    private ColegioService colegioService;

    public ColegioController(ColegioService colegioService) {
        this.colegioService = colegioService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Colegio> save(@RequestBody Colegio colegio) {
        return ResponseEntity.ok().body(this.colegioService.crearColegio(colegio));
    }

    @GetMapping("/listar/{nombre}")
    public ResponseEntity<List<Colegio>> findByNombreContaining(@PathVariable String nombre) {
        return ResponseEntity.ok().body(this.colegioService.findByNombreContaining(nombre));
    }
}
