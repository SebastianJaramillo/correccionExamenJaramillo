package ec.edu.espe.examen.Jaramillo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.Jaramillo.dao.AsignaturaRepository;
import ec.edu.espe.examen.Jaramillo.dao.AlumnoAsignaturaRepository;
import ec.edu.espe.examen.Jaramillo.dao.AlumnoRepository;
import ec.edu.espe.examen.Jaramillo.domain.Alumno;
import ec.edu.espe.examen.Jaramillo.domain.AlumnoAsignatura;
import ec.edu.espe.examen.Jaramillo.domain.Asignatura;
import ec.edu.espe.examen.Jaramillo.domain.AlumnoAsignatura.Estado;
import jakarta.transaction.Transactional;

@Service
public class MatriculaService {

    private final AlumnoRepository alumnoRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final AlumnoAsignaturaRepository alumnoAsignaturaRepository;

    public MatriculaService(AsignaturaRepository asignaturaRepository, AlumnoRepository alumnoRepository,
            AlumnoAsignaturaRepository alumnoAsignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
        this.alumnoRepository = alumnoRepository;
        this.alumnoAsignaturaRepository = alumnoAsignaturaRepository;
    }

    @Transactional
    public AlumnoAsignatura asignarAlumnoAsignatura(AlumnoAsignatura alumnoAsignatura) {
        try {
            Optional<Alumno> optionalAlumno = this.alumnoRepository.findById(alumnoAsignatura.getCodigo().getCodAlumno());
            Optional<Asignatura> optionalAsignatura = this.asignaturaRepository.findById(alumnoAsignatura.getCodigo().getCodAsignatura());

            if (optionalAlumno.isPresent()) {
                if (optionalAsignatura.isPresent()) {
                    Optional<AlumnoAsignatura> optionalAlumnoAsignatura = this.alumnoAsignaturaRepository.findById(alumnoAsignatura.getCodigo());

                    if (!optionalAlumnoAsignatura.isPresent()) {
                        alumnoAsignatura.setEstado(Estado.ACT);
                        return this.alumnoAsignaturaRepository.save(alumnoAsignatura);
                    } else {
                        throw new RuntimeException("Alumno ya ha sido asignado a la Asignatura");
                    }
                } else {
                    throw new RuntimeException("Asignatura con ID: " + alumnoAsignatura.getCodigo().getCodAsignatura() + " no existe");
                }
            } else {
                throw new RuntimeException("Alumno con ID: " + alumnoAsignatura.getCodigo().getCodAlumno() + " no existe");
            }
        } catch (Exception e) {
            throw new CreacionExcepcion("Error en asignación de Alumno: " + alumnoAsignatura.getCodigo().getCodAlumno() + " con Asignatura: "
                    + alumnoAsignatura.getCodigo().getCodAsignatura() + ", el error es: " + e);
        }
    }

    public Iterable<AlumnoAsignatura> findAll() {
        return this.alumnoAsignaturaRepository.findAll();
    }

    public List<AlumnoAsignatura> findByAlumno(Long codAlumno) {
        return this.alumnoAsignaturaRepository.findByCodigo_CodAlumno(codAlumno);
    }
}
