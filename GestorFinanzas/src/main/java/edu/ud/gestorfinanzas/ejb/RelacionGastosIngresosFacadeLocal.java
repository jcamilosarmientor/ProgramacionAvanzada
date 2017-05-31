/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ud.gestorfinanzas.ejb;

import edu.ud.gestorfinanzas.persistencia.RelacionGastosIngresos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Camilo
 */
@Local
public interface RelacionGastosIngresosFacadeLocal {

    void create(RelacionGastosIngresos relacionGastosIngresos);

    void edit(RelacionGastosIngresos relacionGastosIngresos);

    void remove(RelacionGastosIngresos relacionGastosIngresos);

    RelacionGastosIngresos find(Object id);

    List<RelacionGastosIngresos> findAll();

    List<RelacionGastosIngresos> findRange(int[] range);

    int count();
    
}
