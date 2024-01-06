package ec.edu.espe.examen.Jaramillo.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AlumnoAsignaturaId implements Serializable {

    @Column(name = "COD_ALUMNO")
    private Long codAlumno;

    @Column(name = "COD_ASIGNATURA", length = 10)
    private String codAsignatura;
    
    public AlumnoAsignaturaId() {
    }
    
    public AlumnoAsignaturaId(Long codAlumno, String codAsignatura) {
        this.codAlumno = codAlumno;
        this.codAsignatura = codAsignatura;
    }

    public Long getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(Long codAlumno) {
        this.codAlumno = codAlumno;
    }

    public String getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(String codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codAlumno == null) ? 0 : codAlumno.hashCode());
        result = prime * result + ((codAsignatura == null) ? 0 : codAsignatura.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AlumnoAsignaturaId other = (AlumnoAsignaturaId) obj;
        if (codAlumno == null) {
            if (other.codAlumno != null)
                return false;
        } else if (!codAlumno.equals(other.codAlumno))
            return false;
        if (codAsignatura == null) {
            if (other.codAsignatura != null)
                return false;
        } else if (!codAsignatura.equals(other.codAsignatura))
            return false;
        return true;
    }
}
