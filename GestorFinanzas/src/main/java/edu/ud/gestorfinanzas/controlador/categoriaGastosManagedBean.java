package edu.ud.gestorfinanzas.controlador;

import edu.ud.gestorfinanzas.ejb.CategoriaGastosFacadeLocal;
import edu.ud.gestorfinanzas.persistencia.CategoriaGastos;
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
@Named(value = "categoriaGastosManagedBean")
@ViewScoped
public class CategoriaGastosManagedBean {
    
    @EJB
    private CategoriaGastosFacadeLocal categoriaGastosEJB;
    
    private String nombre;
    
    private CategoriaGastos categoriaGastos;
    private List<CategoriaGastos> listaCategoriasGastos;
    
    @PostConstruct
    private void init() {
        categoriaGastos = new CategoriaGastos();
        listaCategoriasGastos = categoriaGastosEJB.findAll();
    }
    public CategoriaGastosManagedBean() {}
    
    public void guardar() {
        try {
            categoriaGastos.setNombre(nombre);
            categoriaGastosEJB.create(categoriaGastos);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","Categoría Registrada"));
        } catch (Exception e) {
            System.out.println("Error en categoriaGastosManagedBean.guardar(): " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Registrar la Categoría"));
        }
    }

    public CategoriaGastos getCategoriaGastos() {
        return categoriaGastos;
    }

    public void setCategoriaGastos(CategoriaGastos categoriaGastos) {
        this.categoriaGastos = categoriaGastos;
    }

    public List<CategoriaGastos> getListaCategoriasGastos() {
        return listaCategoriasGastos;
    }

    public void setListaCategoriasGastos(List<CategoriaGastos> listaCategoriasGastos) {
        this.listaCategoriasGastos = listaCategoriasGastos;
    }
}
