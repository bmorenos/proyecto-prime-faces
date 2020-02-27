/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "asignarcurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignarcurso.findAll", query = "SELECT a FROM Asignarcurso a")
    , @NamedQuery(name = "Asignarcurso.findByIdAsignacion", query = "SELECT a FROM Asignarcurso a WHERE a.idAsignacion = :idAsignacion")})
public class Asignarcurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_asignacion")
    private Integer idAsignacion;
    @JoinColumn(name = "curso_id_curso", referencedColumnName = "id_curso")
    @ManyToOne(optional = false)
    private Curso cursoIdCurso;
    @JoinColumn(name = "inscripcion_id_inscripcion", referencedColumnName = "id_inscripcion")
    @ManyToOne(optional = false)
    private Inscripcion inscripcionIdInscripcion;

    public Asignarcurso() {
    }

    public Asignarcurso(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Curso getCursoIdCurso() {
        return cursoIdCurso;
    }

    public void setCursoIdCurso(Curso cursoIdCurso) {
        this.cursoIdCurso = cursoIdCurso;
    }

    public Inscripcion getInscripcionIdInscripcion() {
        return inscripcionIdInscripcion;
    }

    public void setInscripcionIdInscripcion(Inscripcion inscripcionIdInscripcion) {
        this.inscripcionIdInscripcion = inscripcionIdInscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacion != null ? idAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignarcurso)) {
            return false;
        }
        Asignarcurso other = (Asignarcurso) object;
        if ((this.idAsignacion == null && other.idAsignacion != null) || (this.idAsignacion != null && !this.idAsignacion.equals(other.idAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Asignarcurso[ idAsignacion=" + idAsignacion + " ]";
    }
    
}
