/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.facades;

import com.feriaAdsi.modelo.entities.Juego;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author comapaq
 */
@Stateless
public class JuegoFacade extends AbstractFacade<Juego> implements JuegoFacadeLocal {

    @PersistenceContext(unitName = "feriaAdsiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JuegoFacade() {
        super(Juego.class);
    }
    
}
