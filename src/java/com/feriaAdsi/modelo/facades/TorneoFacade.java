/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.facades;

import com.feriaAdsi.modelo.entities.Torneo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author APRENDIZ
 */
@Stateless
public class TorneoFacade extends AbstractFacade<Torneo> implements TorneoFacadeLocal {

    @PersistenceContext(unitName = "feriaAdsiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TorneoFacade() {
        super(Torneo.class);
    }

    @Override
    public List<Torneo> findByTipo(String tipo) {

        
        try {
            getEntityManager().getEntityManagerFactory().getCache().evictAll();
            TypedQuery<Torneo> q = getEntityManager().createNamedQuery("Torneo.findByTipo", Torneo.class);
            q.setParameter("tipo", tipo);
    
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("No se encontro ningún torneo con ese tipo");
            e.printStackTrace();
            return null;
        }
            

    }

    @Override
    public Torneo findByTipoOne(String tipo) {
        
        try {
            getEntityManager().getEntityManagerFactory().getCache().evictAll();
            TypedQuery<Torneo> q = getEntityManager().createNamedQuery("Torneo.findByTipo", Torneo.class);
            q.setParameter("tipo", tipo);
    
            return q.getSingleResult();
        } catch (Exception e) {
            System.out.println("No se encontro ningún torneo con ese tipo");
            e.printStackTrace();
            return null;
        }

    }
    
    
    
}
