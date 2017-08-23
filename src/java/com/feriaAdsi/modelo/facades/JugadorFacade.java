/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.facades;

import com.feriaAdsi.modelo.entities.Jugador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author APRENDIZ
 */
@Stateless
public class JugadorFacade extends AbstractFacade<Jugador> implements JugadorFacadeLocal {

    @PersistenceContext(unitName = "feriaAdsiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JugadorFacade() {
        super(Jugador.class);
    }

    @Override
    public Jugador findByDocumento(Long documento) {

        try {
            getEntityManager().getEntityManagerFactory().getCache().evictAll();
            TypedQuery<Jugador> j = getEntityManager().createNamedQuery("Jugador.findByDocumento", Jugador.class);
            j.setParameter("documento", documento);
            return j.getSingleResult();
        } catch (Exception e) {
            System.out.println("No se pudo allar nada");
            return null;
        }
    }
    
}
