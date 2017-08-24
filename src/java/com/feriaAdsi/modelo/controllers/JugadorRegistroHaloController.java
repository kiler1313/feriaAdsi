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
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "jugadorRegistroHaloController")
@RequestScoped
public class JugadorRegistroHaloController {

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
    
    public JugadorRegistroHaloController() {
    }
    
    @PostConstruct
    public void init(){
    //Lista torneo hace la busqueda de los torneos por ese nombre     
    listaTorneos = tfl.findByTipo("Halo Reach");
    nuevoJugador = new Jugador();
    nuevaInscripcion = new Inscripcion();
    //Este nuevo torneo va es un campo de la tabla inscripción
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

    public List<Torneo> getListaTorneos() {
        return listaTorneos;
    }

    public void setListaTorneos(List<Torneo> listaTorneos) {
        this.listaTorneos = listaTorneos;
    }
   
    //Existencia del jugador en la base de datos
    public Boolean jugadorRegistrado(){
        
        //Validación por si el jugador se encuentra registrado en la base de datos
        Jugador estaJugador = jfl.findByDocumento(nuevoJugador.getDocumento());
        
        if (estaJugador != null) {
            return true;
        }else {
        
        return false;
        
        }
    
    }
    
    
    public void registrar(){
        
        try {
            if (nuevoJugador != null && torneoSeleccionado != null) {
                
                if (jugadorRegistrado() == true) {
                
                    MessageUtil.enviarMensajeErrorGlobal("Jugador registrado", "El jugador que vas a registrar ya se encuentra en nuestra base de datos.");

                } else{

                
                
                
                
                jfl.create(nuevoJugador);
                nuevaInscripcion.setJugador(nuevoJugador);
                nuevaInscripcion.setTorneo(torneoSeleccionado);
                //El campo ganador hace referencia a si gano la final al principio es 0 pero si gana se convierte en 1
                nuevaInscripcion.setGanador(0);
                ifl.create(nuevaInscripcion);
                
                MessageUtil.enviarMensajeInformacionGlobal("El jugador se ha registrado satisfactoriamente", "El jugador se ha inscrito al torneo con exito");
                
                }
                } else {
                
                MessageUtil.enviarMensajeErrorGlobal("No se pudo registrar el jugador", "El registro tuvo un problema");
                
            }
        } catch (Exception e) {
         
        e.getStackTrace();
     MessageUtil.enviarMensajeErrorGlobal("Lo sentimos, hubo un problema en el servido", "");

        }
        
        }
    
    
    
    
}
