package edu.ud.gestorfinanzas.controlador;

import edu.ud.gestorfinanzas.ejb.FechaLimiteIngresosFacadeLocal;
import edu.ud.gestorfinanzas.ejb.IngresosFacadeLocal;
import edu.ud.gestorfinanzas.persistencia.FechaLimiteIngresos;
import edu.ud.gestorfinanzas.persistencia.Ingresos;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Juan Camilo Sarmiento
 */
@ManagedBean
@Named(value = "ingresosManagedBean")
@ViewScoped
public class IngresosManagedBean implements Serializable {

    @EJB
    private IngresosFacadeLocal ingresosEJB;
    
    @EJB
    private FechaLimiteIngresosFacadeLocal fechaLimiteIngresosEJB;

    private int id;
    private double valor;
    private String descripcion;
    private int idfechaLimite;

    private Ingresos ingresos;
    private List<Ingresos> listaIngresos;

    @PostConstruct
    public void init() {
        ingresos = new Ingresos();
        listaIngresos = ingresosEJB.findAll();
        System.out.println("Lista de Ingresos: " + listaIngresos);
    }

    public IngresosManagedBean() {
    }

    public void guardar() {
        try {
            ingresos.setValor(valor);
            ingresos.setDescripcion(descripcion);
            ingresos.setFechaRegistro(new Date());
            ingresos.setFechaLimiteIngresosId(new FechaLimiteIngresos(idfechaLimite));
            ingresosEJB.create(ingresos);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","Ingreso Registrado"));
        } catch (Exception e) {
            System.out.println("Error en ingresosManagedBeand.guardar() " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Registrar Ingreso"));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getIdfechaLimite() {
        return idfechaLimite;
    }

    public void setIdfechaLimite(int idfechaLimite) {
        this.idfechaLimite = idfechaLimite;
    }

    public List<Ingresos> getListaIngresos() {
        return listaIngresos;
    }

    public void setListaIngresos(List<Ingresos> listaIngresos) {
        this.listaIngresos = listaIngresos;
    }
}
