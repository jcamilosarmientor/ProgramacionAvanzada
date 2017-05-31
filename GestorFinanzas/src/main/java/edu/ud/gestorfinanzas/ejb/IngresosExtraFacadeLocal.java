/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ud.gestorfinanzas.ejb;

import edu.ud.gestorfinanzas.persistencia.IngresosExtra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Camilo
 */
@Local
public interface IngresosExtraFacadeLocal {

    void create(IngresosExtra ingresosExtra);

    void edit(IngresosExtra ingresosExtra);

    void remove(IngresosExtra ingresosExtra);

    IngresosExtra find(Object id);

    List<IngresosExtra> findAll();

    List<IngresosExtra> findRange(int[] range);

    int count();
    
}
