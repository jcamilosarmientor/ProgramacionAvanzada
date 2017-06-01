package edu.ud.gestorfinanzas.controlador;

import edu.ud.gestorfinanzas.ejb.IngresosExtraFacadeLocal;
import edu.ud.gestorfinanzas.persistencia.Ingresos;
import edu.ud.gestorfinanzas.persistencia.IngresosExtra;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Juan Camilo Sarmiento Reyes
 */
@ManagedBean
@Named(value = "ingresosExtraManagedBean")
@ViewScoped
public class IngresosExtraManagedBean {

    @EJB
    private IngresosExtraFacadeLocal ingresosExtraEJB;
    
    private double valor;
    private int idIngreso;
    
    private IngresosExtra ingresoExtra;
    private List<IngresosExtra> listaIngresosExtra;
    
    @PostConstruct
    public void init() {
        ingresoExtra = new IngresosExtra();
        listaIngresosExtra = ingresosExtraEJB.findAll();
    }
    
    public IngresosExtraManagedBean() {}
    
    public void guardar() {
        try {
            ingresoExtra.setValor(valor);
            ingresoExtra.setFechaRegistro(new Date());
            ingresoExtra.setIngresosId(new Ingresos(idIngreso));
            ingresosExtraEJB.create(ingresoExtra);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","Ingreso Adicional Registrado"));
        } catch (Exception e) {
            System.out.println("IngresosExtraManagedBean.guadar(): " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Registrar el Ingreso Adicional"));
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public List<IngresosExtra> getListaIngresosExtra() {
        return listaIngresosExtra;
    }

    public void setListaIngresosExtra(List<IngresosExtra> listaIngresosExtra) {
        this.listaIngresosExtra = listaIngresosExtra;
    }
}
