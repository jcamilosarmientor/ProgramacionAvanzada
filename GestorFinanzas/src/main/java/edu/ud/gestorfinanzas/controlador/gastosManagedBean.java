package edu.ud.gestorfinanzas.controlador;

import edu.ud.gestorfinanzas.ejb.GastosFacadeLocal;
import edu.ud.gestorfinanzas.ejb.RelacionGastosIngresosFacadeLocal;
import edu.ud.gestorfinanzas.persistencia.CategoriaGastos;
import edu.ud.gestorfinanzas.persistencia.Gastos;
import edu.ud.gestorfinanzas.persistencia.Ingresos;
import edu.ud.gestorfinanzas.persistencia.RelacionGastosIngresos;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Juan Camilo Sarmiento Reyes
 */
@ManagedBean
@Named(value = "gastos")
@ViewScoped
public class GastosManagedBean implements Serializable {

    @EJB
    private GastosFacadeLocal gastosEJB;
    
    @EJB
    private RelacionGastosIngresosFacadeLocal relacionGastosIngresosEJB;
    
    private double valor;
    private String descripcion;
    private Date fechaRegistro;
    private String lugar;
    private int idCategoriaGastos;
    private int idIngreso;
   
    private Gastos gasto;
    private List<Gastos> listaGastos;
    
    private RelacionGastosIngresos relacionGastosIngresos;
    
    @PostConstruct
    public void init() {
        gasto = new Gastos();
        relacionGastosIngresos = new RelacionGastosIngresos();
        listaGastos = gastosEJB.findAll();
    }
    
    public GastosManagedBean() {}
    
    public void guardar() {
        try {
            gasto.setValor(valor);
            gasto.setDescripcion(descripcion);
            gasto.setFechaRegistro(fechaRegistro);
            gasto.setLugar(lugar);
            gasto.setCategoriaGastosId(new CategoriaGastos(idCategoriaGastos));
            gastosEJB.create(gasto);
            //Acá comienza el rgistro de la relación gastos ingresos
            relacionGastosIngresos.setIngresosId(new Ingresos(idIngreso));
            relacionGastosIngresos.setGastosId(gasto);
            System.out.println("Creando relación gastos ingresos...");
            relacionGastosIngresosEJB.create(relacionGastosIngresos);
            System.out.println("Creada relación gastos ingresos :)");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","Nuevo Gasto Registrado"));
        } catch (Exception e) {
            System.out.println("Error en gastosManagedBean.guardar(): " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Registrar el Gasto"));
        }
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getIdCategoriaGastos() {
        return idCategoriaGastos;
    }

    public void setIdCategoriaGastos(int idCategoriaGastos) {
        this.idCategoriaGastos = idCategoriaGastos;
    }

    public Gastos getGasto() {
        return gasto;
    }

    public void setGasto(Gastos gasto) {
        this.gasto = gasto;
    }

    public List<Gastos> getListaGastos() {
        return listaGastos;
    }

    public void setListaGastos(List<Gastos> listaGastos) {
        this.listaGastos = listaGastos;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }    
}
