/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ud.gestorfinanzas.persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Camilo
 */
@Entity
@Table(name = "ingresos_extra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresosExtra.findAll", query = "SELECT i FROM IngresosExtra i")
    , @NamedQuery(name = "IngresosExtra.findById", query = "SELECT i FROM IngresosExtra i WHERE i.id = :id")
    , @NamedQuery(name = "IngresosExtra.findByValor", query = "SELECT i FROM IngresosExtra i WHERE i.valor = :valor")
    , @NamedQuery(name = "IngresosExtra.findByFechaRegistro", query = "SELECT i FROM IngresosExtra i WHERE i.fechaRegistro = :fechaRegistro")})
public class IngresosExtra implements Serializable {

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
    @JoinColumn(name = "ingresos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingresos ingresosId;

    public IngresosExtra() {
    }

    public IngresosExtra(Integer id) {
        this.id = id;
    }

    public IngresosExtra(Integer id, double valor, Date fechaRegistro) {
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Ingresos getIngresosId() {
        return ingresosId;
    }

    public void setIngresosId(Ingresos ingresosId) {
        this.ingresosId = ingresosId;
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
        if (!(object instanceof IngresosExtra)) {
            return false;
        }
        IngresosExtra other = (IngresosExtra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ud.gestorfinanzas.persistencia.IngresosExtra[ id=" + id + " ]";
    }
    
}
