package edu.ud.gestorfinanzas.persistencia;

import edu.ud.gestorfinanzas.persistencia.CategoriaGastos;
import edu.ud.gestorfinanzas.persistencia.RelacionGastosIngresos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-02T02:44:00")
@StaticMetamodel(Gastos.class)
public class Gastos_ { 

    public static volatile SingularAttribute<Gastos, String> descripcion;
    public static volatile CollectionAttribute<Gastos, RelacionGastosIngresos> relacionGastosIngresosCollection;
    public static volatile SingularAttribute<Gastos, Date> fechaRegistro;
    public static volatile SingularAttribute<Gastos, String> lugar;
    public static volatile SingularAttribute<Gastos, CategoriaGastos> categoriaGastosId;
    public static volatile SingularAttribute<Gastos, Double> valor;
    public static volatile SingularAttribute<Gastos, Integer> id;

}