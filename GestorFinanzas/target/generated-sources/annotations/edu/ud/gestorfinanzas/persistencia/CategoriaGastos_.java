package edu.ud.gestorfinanzas.persistencia;

import edu.ud.gestorfinanzas.persistencia.Gastos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T20:06:45")
@StaticMetamodel(CategoriaGastos.class)
public class CategoriaGastos_ { 

    public static volatile CollectionAttribute<CategoriaGastos, Gastos> gastosCollection;
    public static volatile SingularAttribute<CategoriaGastos, Integer> id;
    public static volatile SingularAttribute<CategoriaGastos, String> nombre;

}