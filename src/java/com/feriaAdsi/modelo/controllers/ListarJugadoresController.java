/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.controllers;

import com.feriaAdsi.modelo.entities.Jugador;
import com.feriaAdsi.modelo.facades.JugadorFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author cheswill
 */
@Named(value = "listarJugadoresController")
@ViewScoped
public class ListarJugadoresController implements Serializable{

    @EJB
    private JugadorFacadeLocal jfl;
    
    private List<Jugador> jugadores;
    
    public ListarJugadoresController() {
    }
    
    @PostConstruct
    public void init(){
        jugadores = jfl.findAll();
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
    
    
    
}
