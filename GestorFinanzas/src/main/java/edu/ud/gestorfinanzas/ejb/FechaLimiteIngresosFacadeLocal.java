/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ud.gestorfinanzas.ejb;

import edu.ud.gestorfinanzas.persistencia.FechaLimiteIngresos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Camilo
 */
@Local
public interface FechaLimiteIngresosFacadeLocal {

    void create(FechaLimiteIngresos fechaLimiteIngresos);

    void edit(FechaLimiteIngresos fechaLimiteIngresos);

    void remove(FechaLimiteIngresos fechaLimiteIngresos);

    FechaLimiteIngresos find(Object id);

    List<FechaLimiteIngresos> findAll();

    List<FechaLimiteIngresos> findRange(int[] range);

    int count();
    
}
