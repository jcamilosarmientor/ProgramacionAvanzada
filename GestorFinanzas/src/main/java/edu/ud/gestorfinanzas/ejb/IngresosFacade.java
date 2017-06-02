/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ud.gestorfinanzas.ejb;

import edu.ud.gestorfinanzas.persistencia.Ingresos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Camilo
 */
@Stateless
public class IngresosFacade extends AbstractFacade<Ingresos> implements IngresosFacadeLocal {

    @PersistenceContext(unitName = "GestorFinanzasUP")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresosFacade() {
        super(Ingresos.class);
    }
    
}
