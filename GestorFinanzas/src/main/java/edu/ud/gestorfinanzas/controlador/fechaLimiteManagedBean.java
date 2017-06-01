package edu.ud.gestorfinanzas.controlador;

import edu.ud.gestorfinanzas.ejb.FechaLimiteIngresosFacadeLocal;
import edu.ud.gestorfinanzas.persistencia.FechaLimiteIngresos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Juan Camilo Sarmiento Reyes
 */
@ManagedBean
@ViewScoped
public class FechaLimiteManagedBean implements Serializable {

    @EJB
    private FechaLimiteIngresosFacadeLocal fechaLimiteIngresosEJB;
    
    private int diaInicio;
    private int diaFinal;
    
    private FechaLimiteIngresos fechaLimiteIngresos;
    private List<FechaLimiteIngresos> listaFechasLimites;

    @PostConstruct
    public void init() {
        listaFechasLimites = fechaLimiteIngresosEJB.findAll();
    }

    public FechaLimiteManagedBean() {}
    
    public void guardar() {
        try {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","Nuevo Periodo de Gastos Registrado"));
        } catch (Exception e) {
            System.out.println("Error en FechaLimiteManagedBean.guardar(): " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Registrar el Periodo"));
        }
    }

    public List<FechaLimiteIngresos> getListaFechasLimites() {
        return listaFechasLimites;
    }

    public void setListaFechasLimites(List<FechaLimiteIngresos> listaFechasLimites) {
        this.listaFechasLimites = listaFechasLimites;
    }

    public int getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(int diaInicio) {
        this.diaInicio = diaInicio;
    }

    public int getDiaFinal() {
        return diaFinal;
    }

    public void setDiaFinal(int diaFinal) {
        this.diaFinal = diaFinal;
    }
}
