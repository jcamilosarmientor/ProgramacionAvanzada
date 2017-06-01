package edu.ud.gestorfinanzas.controlador;

import edu.ud.gestorfinanzas.ejb.RelacionGastosIngresosFacadeLocal;
import edu.ud.gestorfinanzas.persistencia.RelacionGastosIngresos;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Juan Camilo Sarmiento Reyes
 */
@ManagedBean
@Named(value = "relacionGastosIngresoManagedBean")
@ViewScoped
public class RelacionGastosIngresoManagedBean {

    @EJB
    private RelacionGastosIngresosFacadeLocal relacionGastosIngresosEJB;
    
    private List<RelacionGastosIngresos> listaRelacionGastosIngresos;
    
    @PostConstruct
    public void init() {
        listaRelacionGastosIngresos = relacionGastosIngresosEJB.findAll();
    }
    
    public RelacionGastosIngresoManagedBean() {
    }

    public List<RelacionGastosIngresos> getListaRelacionGastosIngresos() {
        return listaRelacionGastosIngresos;
    }

    public void setListaRelacionGastosIngresos(List<RelacionGastosIngresos> listaRelacionGastosIngresos) {
        this.listaRelacionGastosIngresos = listaRelacionGastosIngresos;
    }
}
