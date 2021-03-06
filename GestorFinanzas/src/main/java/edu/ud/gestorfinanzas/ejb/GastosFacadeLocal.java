/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ud.gestorfinanzas.ejb;

import edu.ud.gestorfinanzas.persistencia.Gastos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Camilo
 */
@Local
public interface GastosFacadeLocal {

    void create(Gastos gastos);

    void edit(Gastos gastos);

    void remove(Gastos gastos);

    Gastos find(Object id);

    List<Gastos> findAll();

    List<Gastos> findRange(int[] range);

    int count();
    
}
