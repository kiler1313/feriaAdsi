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
@Named(value = "partidosRegistroHaloController")
@RequestScoped
public class PartidosRegistroHaloController {

   @EJB
   private InscripcionFacadeLocal ifl;
   @EJB
   private PartidoFacadeLocal pfl;
   @EJB 
   private TorneoFacadeLocal tfl;
   
   private Torneo torneos;
   private Torneo torneoSeleccionado;
   private List<Inscripcion> jugadores;
   private Partido nuevoPartido;
   private Inscripcion jugadorGanador;
   
    public PartidosRegistroHaloController() {
        
    }
    
    @PostConstruct
    public void init(){
        torneos = tfl.findByTipoOne("Halo Reach");
        jugadorGanador = new Inscripcion();
        nuevoPartido = new Partido();
        jugadores = ifl.findByTorneo(torneos);
        
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

    public List<Inscripcion> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Inscripcion> jugadores) {
        this.jugadores = jugadores;
    }
    
    
    
    
   
   
    
    
    public void registrarGrupoA(Inscripcion jugador){
        
        try {
            jugador.setGrupo("A");
            ifl.edit(jugador);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
     public void registrarGrupoB(Inscripcion jugador){
        
        try {
            jugador.setGrupo("B");
            ifl.edit(jugador);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
      public void registrarGrupoC(Inscripcion jugador){
        
        try {
            jugador.setGrupo("C");
            ifl.edit(jugador);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
      
       public void registrarGrupoD(Inscripcion jugador){
        
        try {
            jugador.setGrupo("D");
            ifl.edit(jugador);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
    
   
    
    
}
