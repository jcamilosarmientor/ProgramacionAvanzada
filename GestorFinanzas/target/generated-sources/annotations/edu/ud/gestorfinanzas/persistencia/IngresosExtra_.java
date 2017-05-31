package edu.ud.gestorfinanzas.persistencia;

import edu.ud.gestorfinanzas.persistencia.Ingresos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T20:06:45")
@StaticMetamodel(IngresosExtra.class)
public class IngresosExtra_ { 

    public static volatile SingularAttribute<IngresosExtra, Ingresos> ingresosId;
    public static volatile SingularAttribute<IngresosExtra, Date> fechaRegistro;
    public static volatile SingularAttribute<IngresosExtra, Double> valor;
    public static volatile SingularAttribute<IngresosExtra, Integer> id;

}