/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ud.gestorfinanzas.ejb;

import edu.ud.gestorfinanzas.persistencia.Ingresos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Camilo
 */
@Local
public interface IngresosFacadeLocal {

    void create(Ingresos ingresos);

    void edit(Ingresos ingresos);

    void remove(Ingresos ingresos);

    Ingresos find(Object id);

    List<Ingresos> findAll();

    List<Ingresos> findRange(int[] range);

    int count();
    
}
