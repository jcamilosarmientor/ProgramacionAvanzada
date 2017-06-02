package edu.ud.gestorfinanzas.persistencia;

import edu.ud.gestorfinanzas.persistencia.Ingresos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-02T02:44:00")
@StaticMetamodel(FechaLimiteIngresos.class)
public class FechaLimiteIngresos_ { 

    public static volatile SingularAttribute<FechaLimiteIngresos, Short> diaInicio;
    public static volatile SingularAttribute<FechaLimiteIngresos, Short> diaFin;
    public static volatile SingularAttribute<FechaLimiteIngresos, Integer> id;
    public static volatile CollectionAttribute<FechaLimiteIngresos, Ingresos> ingresosCollection;

}