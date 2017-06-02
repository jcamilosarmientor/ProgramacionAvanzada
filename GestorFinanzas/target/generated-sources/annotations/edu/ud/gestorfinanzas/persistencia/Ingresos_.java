package edu.ud.gestorfinanzas.persistencia;

import edu.ud.gestorfinanzas.persistencia.FechaLimiteIngresos;
import edu.ud.gestorfinanzas.persistencia.IngresosExtra;
import edu.ud.gestorfinanzas.persistencia.RelacionGastosIngresos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-02T02:44:00")
@StaticMetamodel(Ingresos.class)
public class Ingresos_ { 

    public static volatile SingularAttribute<Ingresos, String> descripcion;
    public static volatile CollectionAttribute<Ingresos, IngresosExtra> ingresosExtraCollection;
    public static volatile CollectionAttribute<Ingresos, RelacionGastosIngresos> relacionGastosIngresosCollection;
    public static volatile SingularAttribute<Ingresos, Date> fechaRegistro;
    public static volatile SingularAttribute<Ingresos, Double> valor;
    public static volatile SingularAttribute<Ingresos, FechaLimiteIngresos> fechaLimiteIngresosId;
    public static volatile SingularAttribute<Ingresos, Integer> id;

}