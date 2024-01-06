package ec.edu.espe.examen.Jaramillo.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "ALUMNO_ASIGNATURA")
public class AlumnoAsignatura {

    @EmbeddedId
    private AlumnoAsignaturaId codigo;

    @ManyToOne
    @JoinColumn(name = "COD_ALUMNO", insertable = false, updatable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "COD_ASIGNATURA", insertable = false, updatable = false)
    private Asignatura asignatura;

    @Column(name = "CALIFICACION1", precision = 4, scale = 2)
    private BigDecimal calificacion1;

    @Column(name = "CALIFICACION2", precision = 4, scale = 2)
    private BigDecimal calificacion2;

    @Column(name = "CALIFICACION3", precision = 4, scale = 2)
    private BigDecimal calificacion3;

    @Column(name = "PROMEDIO", precision = 4, scale = 2)
    private BigDecimal promedio;

    @Column(name = "ESTADO", nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Version
    private Long version;

    public AlumnoAsignatura() {
    }

    public AlumnoAsignatura(AlumnoAsignaturaId codigo) {
        this.codigo = codigo;
    }

    public AlumnoAsignaturaId getCodigo() {
        return codigo;
    }

    public void setCodigo(AlumnoAsignaturaId codigo) {
        this.codigo = codigo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public BigDecimal getCalificacion1() {
        return calificacion1;
    }

    public void setCalificacion1(BigDecimal calificacion1) {
        this.calificacion1 = calificacion1;
    }

    public BigDecimal getCalificacion2() {
        return calificacion2;
    }

    public void setCalificacion2(BigDecimal calificacion2) {
        this.calificacion2 = calificacion2;
    }

    public BigDecimal getCalificacion3() {
        return calificacion3;
    }

    public void setCalificacion3(BigDecimal calificacion3) {
        this.calificacion3 = calificacion3;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
        AlumnoAsignatura other = (AlumnoAsignatura) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AlumnoAsignatura [codigo=" + codigo + ", alumno=" + alumno + ", asignatura=" + asignatura
                + ", calificacion1=" + calificacion1 + ", calificacion2=" + calificacion2 + ", calificacion3="
                + calificacion3 + ", promedio=" + promedio + ", estado=" + estado + "]";
    }

    public enum Estado {
        ACT,
        INA
    }
}
