package ec.edu.espe.examen.Jaramillo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.examen.Jaramillo.domain.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

    Optional<Alumno> findByCedula(String cedula);
}
