/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.controllers;

import com.feriaAdsi.modelo.entities.Inscripcion;
import com.feriaAdsi.modelo.entities.Jugador;
import com.feriaAdsi.modelo.entities.Torneo;
import com.feriaAdsi.modelo.facade.util.MessageUtil;
import com.feriaAdsi.modelo.facades.InscripcionFacadeLocal;
import com.feriaAdsi.modelo.facades.JugadorFacadeLocal;
import com.feriaAdsi.modelo.facades.TorneoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "jugadorRegistroController")
@RequestScoped
public class JugadorRegistroController {

    @EJB
    private JugadorFacadeLocal jfl;
    
    @EJB
    private TorneoFacadeLocal tfl;
    
    @EJB 
    private InscripcionFacadeLocal ifl;
    
    private List<Torneo> listaTorneos;
    
    private Inscripcion nuevaInscripcion;
    
    private Torneo torneoSeleccionado;
    
    
    private Jugador nuevoJugador;
    
    public JugadorRegistroController() {
    }
    
    public void init(){
        
    listaTorneos = tfl.findAll();
    nuevoJugador = new Jugador();
    nuevaInscripcion = new Inscripcion();
    torneoSeleccionado = new Torneo();
    
    }

    public Jugador getNuevoJugador() {
        return nuevoJugador;
    }

    public void setNuevoJugador(Jugador nuevoJugador) {
        this.nuevoJugador = nuevoJugador;
    }

    public Torneo getTorneoSeleccionado() {
        return torneoSeleccionado;
    }

    public void setTorneoSeleccionado(Torneo torneoSeleccionado) {
        this.torneoSeleccionado = torneoSeleccionado;
    }
    
    
    
    public void registrar(){
        if (nuevoJugador != null && torneoSeleccionado != null) {
            
            jfl.create(nuevoJugador);
            nuevaInscripcion.setJugador(nuevoJugador);
            nuevaInscripcion.setTorneo(torneoSeleccionado);
            nuevaInscripcion.setGanador(0);
            ifl.create(nuevaInscripcion);
            
            MessageUtil.enviarMensajeInformacionGlobal("El jugador se ha registrado satisfactoriamente", "El jugador se ha inscrito al torneo con exito");
            
        } else {
        
            MessageUtil.enviarMensajeErrorGlobal("No se pudo registrar el jugador", "El registro tuvo un problema");
        
        }
    
    
    
    }
    
}
