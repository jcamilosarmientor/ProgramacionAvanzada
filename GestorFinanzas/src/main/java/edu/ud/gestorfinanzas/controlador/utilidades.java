package edu.ud.gestorfinanzas.controlador;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Juan Camilo Sarmiento Reyes
 */

@Named
@ViewScoped
public class utilidades implements Serializable{
    
    private String icono;
    
    @PostConstruct
    public void init() {
        icono = "fa fa-arrow-circle-right";
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}
