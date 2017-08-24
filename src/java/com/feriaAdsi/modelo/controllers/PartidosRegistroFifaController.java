/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.controllers;

import com.feriaAdsi.modelo.entities.Inscripcion;

import com.feriaAdsi.modelo.entities.Partido;
import com.feriaAdsi.modelo.entities.Torneo;
import com.feriaAdsi.modelo.facades.InscripcionFacadeLocal;

import com.feriaAdsi.modelo.facades.PartidoFacadeLocal;
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
@Named(value = "partidosRegistroController")
@RequestScoped
public class PartidosRegistroFifaController {

   @EJB
   private InscripcionFacadeLocal ifl;
   @EJB
   private PartidoFacadeLocal pfl;
   @EJB 
   private TorneoFacadeLocal tfl;
   
   private List<Torneo> torneos;
   private Torneo torneoSeleccionado;
   private List<Inscripcion> jugadores;
   private Partido nuevoPartido;
   private Inscripcion jugadorGanador;
   
    public PartidosRegistroFifaController() {
        
    }
    
    @PostConstruct
    public void init(){
        torneos = tfl.findByTipo("Fifa 2017");
        jugadorGanador = new Inscripcion();
        nuevoPartido = new Partido();
        jugadores = ifl.findByTorneo(getTorneoSeleccionado());
    }
    

    public Partido getNuevoPartido() {
        return nuevoPartido;
    }

    public void setNuevoPartido(Partido nuevoPartido) {
        this.nuevoPartido = nuevoPartido;
    }

    public Torneo getTorneoSeleccionado() {
        return torneoSeleccionado;
    }

    public void setTorneoSeleccionado(Torneo torneoSeleccionado) {
        this.torneoSeleccionado = torneoSeleccionado;
    }
    
    
   
   
    
    
    public void registrarRondaInicial(Inscripcion jugador1, Inscripcion jugador2){
        
        try {
            nuevoPartido.setJugador1(jugador1);
            nuevoPartido.setJugador2(jugador2);
            nuevoPartido.setResultado1(nuevoPartido.getResultado1());
            nuevoPartido.setResultado2(nuevoPartido.getResultado2());
            nuevoPartido.setRonda("Inicial");
            pfl.create(nuevoPartido);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
    
    public void registrarRondaOctavos(Inscripcion jugador1, Inscripcion jugador2){
        
        try {
            nuevoPartido.setJugador1(jugador1);
            nuevoPartido.setJugador2(jugador2);
            nuevoPartido.setResultado1(nuevoPartido.getResultado1());
            nuevoPartido.setResultado2(nuevoPartido.getResultado2());
            nuevoPartido.setRonda("Octavos");
            pfl.create(nuevoPartido);
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
    
     public void registrarRondaCuartos(Inscripcion jugador1, Inscripcion jugador2){
        
         try {
             nuevoPartido.setJugador1(jugador1);
             nuevoPartido.setJugador2(jugador2);
             nuevoPartido.setResultado1(nuevoPartido.getResultado1());
             nuevoPartido.setResultado2(nuevoPartido.getResultado2());
             nuevoPartido.setRonda("Cuartos");
             pfl.create(nuevoPartido);
         } catch (Exception e) {
             e.printStackTrace();
         }
   }
     
     public void registrarRondaSemifinal(Inscripcion jugador1, Inscripcion jugador2){
        
         try {
             nuevoPartido.setJugador1(jugador1);
             nuevoPartido.setJugador2(jugador2);
             nuevoPartido.setResultado1(nuevoPartido.getResultado1());
             nuevoPartido.setResultado2(nuevoPartido.getResultado2());
             nuevoPartido.setRonda("Semifinal");
             pfl.create(nuevoPartido);
         } catch (Exception e) {
             e.printStackTrace();
         }
   }
     public void registrarRondaFinal(Inscripcion jugador1, Inscripcion jugador2){
        
         try {
             nuevoPartido.setJugador1(jugador1);
             nuevoPartido.setJugador2(jugador2);
             nuevoPartido.setResultado1(nuevoPartido.getResultado1());
             nuevoPartido.setResultado2(nuevoPartido.getResultado2());
             nuevoPartido.setRonda("Final");
             pfl.create(nuevoPartido);
         } catch (Exception e) {
             e.printStackTrace();
         }
   }
     
     public void registrarGanador(Inscripcion jugador1){
        
         try {
             jugadorGanador = jugador1;
             jugadorGanador.setGanador(1);
             ifl.edit(jugadorGanador);
         } catch (Exception e) {
             e.printStackTrace();
         }
   }
    
}
