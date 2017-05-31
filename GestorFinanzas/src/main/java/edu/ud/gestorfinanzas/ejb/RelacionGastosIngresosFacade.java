/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ud.gestorfinanzas.ejb;

import edu.ud.gestorfinanzas.persistencia.RelacionGastosIngresos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Camilo
 */
@Stateless
public class RelacionGastosIngresosFacade extends AbstractFacade<RelacionGastosIngresos> implements RelacionGastosIngresosFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_GestorFinanzas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RelacionGastosIngresosFacade() {
        super(RelacionGastosIngresos.class);
    }
    
}
