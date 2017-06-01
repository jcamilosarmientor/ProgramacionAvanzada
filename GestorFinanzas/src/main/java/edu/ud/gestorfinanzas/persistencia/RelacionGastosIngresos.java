/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ud.gestorfinanzas.persistencia;

import java.io.Serializable;
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

/**
 *
 * @author Juan Camilo
 */
@Entity
@Table(name = "relacion_gastos_ingresos")
@NamedQueries({
    @NamedQuery(name = "RelacionGastosIngresos.findAll", query = "SELECT r FROM RelacionGastosIngresos r")
    , @NamedQuery(name = "RelacionGastosIngresos.findById", query = "SELECT r FROM RelacionGastosIngresos r WHERE r.id = :id")})
public class RelacionGastosIngresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "gastos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Gastos gastosId;
    @JoinColumn(name = "ingresos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingresos ingresosId;

    public RelacionGastosIngresos() {
    }

    public RelacionGastosIngresos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Gastos getGastosId() {
        return gastosId;
    }

    public void setGastosId(Gastos gastosId) {
        this.gastosId = gastosId;
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
        if (!(object instanceof RelacionGastosIngresos)) {
            return false;
        }
        RelacionGastosIngresos other = (RelacionGastosIngresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ud.gestorfinanzas.persistencia.RelacionGastosIngresos[ id=" + id + " ]";
    }
    
}
