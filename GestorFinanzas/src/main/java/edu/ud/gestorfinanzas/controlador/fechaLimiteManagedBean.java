/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ud.gestorfinanzas.controlador;

import edu.ud.gestorfinanzas.ejb.FechaLimiteIngresosFacade;
import edu.ud.gestorfinanzas.ejb.FechaLimiteIngresosFacadeLocal;
import edu.ud.gestorfinanzas.persistencia.FechaLimiteIngresos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Juan Camilo
 */
@ManagedBean
@ViewScoped
public class fechaLimiteManagedBean implements Serializable {

    @EJB
    private FechaLimiteIngresosFacadeLocal fechaLimiteIngresosEJB;

    private List<FechaLimiteIngresos> fechasLimites;

    @PostConstruct
    public void init() {
        fechasLimites = fechaLimiteIngresosEJB.findAll();
    }

    public fechaLimiteManagedBean() {
    }

    public List<FechaLimiteIngresos> getFechasLimites() {
        return fechasLimites;
    }

    public void setFechasLimites(List<FechaLimiteIngresos> fechasLimites) {
        this.fechasLimites = fechasLimites;
    }
}
