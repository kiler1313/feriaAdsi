/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.facades;

import com.feriaAdsi.modelo.entities.Inscripcion;
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
public class InscripcionFacade extends AbstractFacade<Inscripcion> implements InscripcionFacadeLocal {

    @PersistenceContext(unitName = "feriaAdsiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InscripcionFacade() {
        super(Inscripcion.class);
    }

    @Override
    public List<Inscripcion> findByTorneo(Torneo torneo) {
        
        try {
            getEntityManager().getEntityManagerFactory().getCache().evictAll();
            TypedQuery<Inscripcion> i = getEntityManager().createNamedQuery("Inscripcion.findByTorneo", Inscripcion.class);
            i.setParameter("torneo", torneo);
            return i.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fallo la busqueda de la inscripcion por torneo");
            return null;
        }

    }

    @Override
    public List<Inscripcion> findByGrupo(String grupo, Torneo torneo) {
        
           
        try {
            getEntityManager().getEntityManagerFactory().getCache().evictAll();
            TypedQuery<Inscripcion> i = getEntityManager().createNamedQuery("Inscripcion.findByGrupo", Inscripcion.class);
            i.setParameter("grupo", grupo);
            i.setParameter("torneo", torneo);
            return i.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fallo la busqueda de la inscripcion por torneo y grupo");
            return null;
        }
    }
    
}
