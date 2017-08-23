/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.controllers;

import com.feriaAdsi.modelo.entities.Torneo;
import com.feriaAdsi.modelo.facade.util.MessageUtil;
import com.feriaAdsi.modelo.facades.TorneoFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "torneoRegistroController")
@RequestScoped
public class TorneoRegistroController {

    @EJB 
    private TorneoFacadeLocal tfl;
    
    private Torneo nuevoTorneo;
    
    public TorneoRegistroController() {
        
    }
    @PostConstruct
    public void init(){
    nuevoTorneo = new Torneo();
    
    }

    public Torneo getNuevoTorneo() {
        return nuevoTorneo;
    }

    public void setNuevoTorneo(Torneo nuevoTorneo) {
        this.nuevoTorneo = nuevoTorneo;
    }
    
    public void registrar(){
        if (nuevoTorneo != null) {
            
         tfl.create(nuevoTorneo);
            MessageUtil.enviarMensajeInformacionGlobal("Torneo Creado Satisfactoriamente","Se ha registrado el torneo correctamente");
        }
        
    }
    
    
    
}
