/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ud.gestorfinanzas.ejb;

import edu.ud.gestorfinanzas.persistencia.CategoriaGastos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Camilo
 */
@Local
public interface CategoriaGastosFacadeLocal {

    void create(CategoriaGastos categoriaGastos);

    void edit(CategoriaGastos categoriaGastos);

    void remove(CategoriaGastos categoriaGastos);

    CategoriaGastos find(Object id);

    List<CategoriaGastos> findAll();

    List<CategoriaGastos> findRange(int[] range);

    int count();
    
}
