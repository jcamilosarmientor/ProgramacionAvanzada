/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ud.gestorfinanzas.persistencia;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Camilo
 */
@Entity
@Table(name = "ingresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingresos.findAll", query = "SELECT i FROM Ingresos i")
    , @NamedQuery(name = "Ingresos.findById", query = "SELECT i FROM Ingresos i WHERE i.id = :id")
    , @NamedQuery(name = "Ingresos.findByValor", query = "SELECT i FROM Ingresos i WHERE i.valor = :valor")
    , @NamedQuery(name = "Ingresos.findByFechaRegistro", query = "SELECT i FROM Ingresos i WHERE i.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Ingresos.findByDescripcion", query = "SELECT i FROM Ingresos i WHERE i.descripcion = :descripcion")})
public class Ingresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    
    @JoinColumn(name = "fecha_limite_ingresos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FechaLimiteIngresos fechaLimiteIngresosId;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "ingresosId")
    private Collection<IngresosExtra> ingresosExtraCollection;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "ingresosId")
    private Collection<RelacionGastosIngresos> relacionGastosIngresosCollection;

    public Ingresos() {
    }

    public Ingresos(Integer id) {
        this.id = id;
    }

    public Ingresos(Integer id, double valor, Date fechaRegistro, String descripcion) {
        this.id = id;
        this.valor = valor;
        this.fechaRegistro = fechaRegistro;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FechaLimiteIngresos getFechaLimiteIngresosId() {
        return fechaLimiteIngresosId;
    }

    public void setFechaLimiteIngresosId(FechaLimiteIngresos fechaLimiteIngresosId) {
        this.fechaLimiteIngresosId = fechaLimiteIngresosId;
    }

    @XmlTransient
    public Collection<IngresosExtra> getIngresosExtraCollection() {
        return ingresosExtraCollection;
    }

    public void setIngresosExtraCollection(Collection<IngresosExtra> ingresosExtraCollection) {
        this.ingresosExtraCollection = ingresosExtraCollection;
    }

    @XmlTransient
    public Collection<RelacionGastosIngresos> getRelacionGastosIngresosCollection() {
        return relacionGastosIngresosCollection;
    }

    public void setRelacionGastosIngresosCollection(Collection<RelacionGastosIngresos> relacionGastosIngresosCollection) {
        this.relacionGastosIngresosCollection = relacionGastosIngresosCollection;
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
        if (!(object instanceof Ingresos)) {
            return false;
        }
        Ingresos other = (Ingresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ud.gestorfinanzas.persistencia.Ingresos[ id=" + id + " ]";
    }
    
}
