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
@Table(name = "gastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gastos.findAll", query = "SELECT g FROM Gastos g")
    , @NamedQuery(name = "Gastos.findById", query = "SELECT g FROM Gastos g WHERE g.id = :id")
    , @NamedQuery(name = "Gastos.findByValor", query = "SELECT g FROM Gastos g WHERE g.valor = :valor")
    , @NamedQuery(name = "Gastos.findByDescripcion", query = "SELECT g FROM Gastos g WHERE g.descripcion = :descripcion")
    , @NamedQuery(name = "Gastos.findByFechaRegistro", query = "SELECT g FROM Gastos g WHERE g.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Gastos.findByLugar", query = "SELECT g FROM Gastos g WHERE g.lugar = :lugar")})
public class Gastos implements Serializable {

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
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 45)
    @Column(name = "lugar")
    private String lugar;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "gastosId")
    private Collection<RelacionGastosIngresos> relacionGastosIngresosCollection;
    @JoinColumn(name = "categoria_gastos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CategoriaGastos categoriaGastosId;

    public Gastos() {
    }

    public Gastos(Integer id) {
        this.id = id;
    }

    public Gastos(Integer id, double valor, Date fechaRegistro) {
        this.id = id;
        this.valor = valor;
        this.fechaRegistro = fechaRegistro;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @XmlTransient
    public Collection<RelacionGastosIngresos> getRelacionGastosIngresosCollection() {
        return relacionGastosIngresosCollection;
    }

    public void setRelacionGastosIngresosCollection(Collection<RelacionGastosIngresos> relacionGastosIngresosCollection) {
        this.relacionGastosIngresosCollection = relacionGastosIngresosCollection;
    }

    public CategoriaGastos getCategoriaGastosId() {
        return categoriaGastosId;
    }

    public void setCategoriaGastosId(CategoriaGastos categoriaGastosId) {
        this.categoriaGastosId = categoriaGastosId;
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
        if (!(object instanceof Gastos)) {
            return false;
        }
        Gastos other = (Gastos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ud.gestorfinanzas.persistencia.Gastos[ id=" + id + " ]";
    }
    
}
