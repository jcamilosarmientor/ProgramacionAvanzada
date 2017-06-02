package edu.ud.gestorfinanzas.controlador;

import edu.ud.gestorfinanzas.ejb.RelacionGastosIngresosFacadeLocal;
import edu.ud.gestorfinanzas.persistencia.RelacionGastosIngresos;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Juan Camilo Sarmiento Reyes
 */
@ManagedBean
@Named(value = "balance")
@ViewScoped
public class BalanceManagedBean implements Serializable{
    
    @EJB
    private RelacionGastosIngresosFacadeLocal relacionGastosIngresosEJB;
    
    private List<RelacionGastosIngresos> relacionGastosIngresos;
    
   private LineChartModel lineModel1;
     
    @PostConstruct
    public void init() {
        relacionGastosIngresos = relacionGastosIngresosEJB.findAll();
        createLineModels();
    }
 
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
     
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Relación de Gastos con Ingresos");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(8000000);
    }
     
    private LineChartModel initLinearModel() {
        int cont = 1;
        LineChartModel model = new LineChartModel();
        
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Ingresos");
        
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Gastos");
        
        for (RelacionGastosIngresos relacion : relacionGastosIngresos) {
            series1.set(cont, relacion.getIngresosId().getValor());
            series2.set(cont, relacion.getGastosId().getValor());
            cont++;
        }
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }
    
    public BalanceManagedBean() {
    }
    
}
