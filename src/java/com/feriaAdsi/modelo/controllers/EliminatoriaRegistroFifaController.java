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
@Named(value = "eliminatoriaRegistroFifaController")
@RequestScoped
public class EliminatoriaRegistroFifaController {

   @EJB
   private InscripcionFacadeLocal ifl;
   @EJB
   private PartidoFacadeLocal pfl;
   @EJB 
   private TorneoFacadeLocal tfl;
  
   private Torneo torneo;
   private List<Inscripcion> grupoA;
   private List<Inscripcion> grupoB;
   private List<Inscripcion> grupoC;
   private List<Inscripcion> grupoD;
   
   private Partido partido1 ;
           
   private Partido partido2 ;
   
   
    public EliminatoriaRegistroFifaController() {
        
    }
    
    
    @PostConstruct
    public void init(){
        torneo = tfl.find(1);
        grupoA = ifl.findByGrupo("A", torneo);
        grupoB = ifl.findByGrupo("B", torneo);
        grupoC = ifl.findByGrupo("C", torneo);
        grupoC = ifl.findByGrupo("D", torneo);
        partido1 = new Partido();
        partido2 = new Partido();
       
    }

    public List<Inscripcion> getGrupoA() {
        return grupoA;
    }

    public void setGrupoA(List<Inscripcion> grupoA) {
        this.grupoA = grupoA;
    }

    public List<Inscripcion> getGrupoB() {
        return grupoB;
    }

    public void setGrupoB(List<Inscripcion> grupoB) {
        this.grupoB = grupoB;
    }

    public List<Inscripcion> getGrupoC() {
        return grupoC;
    }

    public void setGrupoC(List<Inscripcion> grupoC) {
        this.grupoC = grupoC;
    }

    public List<Inscripcion> getGrupoD() {
        return grupoD;
    }

    public void setGrupoD(List<Inscripcion> grupoD) {
        this.grupoD = grupoD;
    }
    
    
    
       
       public void generarPartidosA(){
       
           
          
           partido1.setJugador1(grupoA.get(0));
           partido1.setResultado1(0);
           partido1.setResultado2(0);
           partido1.setRonda("1");
           partido1.setJugador2(grupoA.get(1));
           partido2.setJugador1(grupoA.get(2));
           partido2.setResultado1(0);
           partido2.setResultado2(0);
           partido2.setRonda("1");
           partido2.setJugador2(grupoA.get(3));
           
           pfl.create(partido1);
           pfl.create(partido2);
           
           }
       
       public void generarPartidosB(){
       
           
          
           partido1.setJugador1(grupoB.get(0));
           partido1.setJugador2(grupoB.get(1));
           partido1.setResultado1(0);
           partido1.setResultado2(0);
           partido1.setRonda("1");
           partido2.setJugador1(grupoB.get(2));
           partido2.setResultado1(0);
           partido2.setResultado2(0);
           partido2.setRonda("1");
           partido2.setJugador2(grupoB.get(3));
           
           pfl.create(partido1);
           pfl.create(partido2);
           
       }
       
          public void generarPartidosC(){
     
          
           partido1.setJugador1(grupoC.get(0));
           partido1.setJugador2(grupoC.get(1));
           partido1.setResultado1(0);
           partido1.setResultado2(0);
           partido1.setRonda("1");
           partido2.setJugador1(grupoC.get(2));
           partido2.setResultado1(0);
           partido2.setResultado2(0);
           partido2.setRonda("1");
           partido2.setJugador2(grupoC.get(3));
           
           pfl.create(partido1);
           pfl.create(partido2);
           
       }
          
      public void generarPartidosD(){
    
          
           partido1.setJugador1(grupoD.get(0));
           partido1.setJugador2(grupoD.get(1));
           partido1.setResultado1(0);
           partido1.setResultado2(0);
           partido1.setRonda("1");
           partido2.setJugador1(grupoD.get(2));
           partido2.setResultado1(0);
           partido2.setResultado2(0);
           partido2.setRonda("1");
           partido2.setJugador2(grupoD.get(3));
           
           pfl.create(partido1);
           pfl.create(partido2);
           
       }
       
    
   
    
    
}
