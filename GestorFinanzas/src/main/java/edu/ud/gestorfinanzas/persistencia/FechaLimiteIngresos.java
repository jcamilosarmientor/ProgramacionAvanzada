/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ud.gestorfinanzas.persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Camilo
 */
@Entity
@Table(name = "fecha_limite_ingresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FechaLimiteIngresos.findAll", query = "SELECT f FROM FechaLimiteIngresos f")
    , @NamedQuery(name = "FechaLimiteIngresos.findById", query = "SELECT f FROM FechaLimiteIngresos f WHERE f.id = :id")
    , @NamedQuery(name = "FechaLimiteIngresos.findByDiaInicio", query = "SELECT f FROM FechaLimiteIngresos f WHERE f.diaInicio = :diaInicio")
    , @NamedQuery(name = "FechaLimiteIngresos.findByDiaFin", query = "SELECT f FROM FechaLimiteIngresos f WHERE f.diaFin = :diaFin")})
public class FechaLimiteIngresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dia_inicio")
    private Short diaInicio;
    @Column(name = "dia_fin")
    private Short diaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fechaLimiteIngresosId")
    private Collection<Ingresos> ingresosCollection;

    public FechaLimiteIngresos() {
    }

    public FechaLimiteIngresos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(Short diaInicio) {
        this.diaInicio = diaInicio;
    }

    public Short getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(Short diaFin) {
        this.diaFin = diaFin;
    }

    @XmlTransient
    public Collection<Ingresos> getIngresosCollection() {
        return ingresosCollection;
    }

    public void setIngresosCollection(Collection<Ingresos> ingresosCollection) {
        this.ingresosCollection = ingresosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FechaLimiteIngresos)) {
            return false;
        }
        FechaLimiteIngresos other = (FechaLimiteIngresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ud.gestorfinanzas.persistencia.FechaLimiteIngresos[ id=" + id + " ]";
    }
    
}
