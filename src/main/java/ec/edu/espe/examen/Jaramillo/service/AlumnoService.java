package ec.edu.espe.examen.Jaramillo.service;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.Jaramillo.dao.AlumnoRepository;
import ec.edu.espe.examen.Jaramillo.dao.ColegioRepository;
import ec.edu.espe.examen.Jaramillo.domain.Alumno;
import ec.edu.espe.examen.Jaramillo.domain.Colegio;
import jakarta.transaction.Transactional;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final ColegioRepository colegioRepository;

    public AlumnoService(AlumnoRepository alumnoRepository, ColegioRepository colegioRepository) {
        this.alumnoRepository = alumnoRepository;
        this.colegioRepository = colegioRepository;
    }

    @Transactional
    public Alumno crearAlumno(Alumno alumno) {
        try {
            Optional<Alumno> optionalAlumno = this.alumnoRepository.findByCedula(alumno.getCedula());
            Optional<Colegio> optionalColegio = this.colegioRepository.findById(alumno.getCodColegio());

            if (optionalColegio.isPresent()) {
                Calendar fechaActual = Calendar.getInstance();

                Calendar fechaNacimiento = Calendar.getInstance();
                fechaNacimiento.setTime(alumno.getFechaNacimiento());

                if (fechaNacimiento.before(fechaActual)) {
                    if (!optionalAlumno.isPresent()) {
                        alumno.setFechaCreacion(fechaActual.getTime());
                        return this.alumnoRepository.save(alumno);
                    } else {
                        throw new RuntimeException("Alumno con cedula: " + alumno.getCedula() + " ya existe");
                    }
                } else {
                    throw new RuntimeException("La fecha de Nacimiento no es menor a la fecha Actual");
                }
            } else {
                throw new RuntimeException("El colegio enviado no esta registrado");
            }
        } catch (Exception e) {
            throw new CreacionExcepcion("Error en creacion de Alumno: " + alumno + " el error es: " + e);
        }
    }

    public Iterable<Alumno> findAll() {
        return this.alumnoRepository.findAll();
    }
}