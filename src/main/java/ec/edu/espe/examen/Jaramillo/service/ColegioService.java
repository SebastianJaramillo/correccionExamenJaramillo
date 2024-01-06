package ec.edu.espe.examen.Jaramillo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.Jaramillo.dao.ColegioRepository;
import ec.edu.espe.examen.Jaramillo.domain.Colegio;
import jakarta.transaction.Transactional;

@Service
public class ColegioService {

    private final ColegioRepository colegioRepository;

    public ColegioService(ColegioRepository colegioRepository) {
        this.colegioRepository = colegioRepository;
    }

    @Transactional
    public Colegio crearColegio(Colegio colegio) {
        try {
            Optional<Colegio> optionalColegio = this.colegioRepository.findByNombre(colegio.getNombre());

            if (!optionalColegio.isPresent()) {
                return this.colegioRepository.save(colegio);
            } else {
                throw new RuntimeException("Colegio: " + colegio.getNombre() + " ya existe.");
            }
        } catch (Exception e) {
            throw new CreacionExcepcion("No se pudo crear colegio: " + colegio + ", error: " + e);
        }
    }

    public List<Colegio> findByNombreContaining(String nombre) {
        return this.colegioRepository.findByNombreContaining(nombre);
    }
}
