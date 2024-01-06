package ec.edu.espe.examen.Jaramillo.dao;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.examen.Jaramillo.domain.AlumnoAsignatura;
import ec.edu.espe.examen.Jaramillo.domain.AlumnoAsignaturaId;
import java.util.List;


public interface AlumnoAsignaturaRepository extends CrudRepository<AlumnoAsignatura, AlumnoAsignaturaId> {

    List<AlumnoAsignatura> findByCodigo_CodAlumno(Long codAlumno);
}
