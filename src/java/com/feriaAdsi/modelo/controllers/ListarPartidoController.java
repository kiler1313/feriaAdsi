/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.controllers;

import com.feriaAdsi.modelo.entities.Partido;
import com.feriaAdsi.modelo.facades.PartidoFacadeLocal;
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
@Named(value = "listarPartidoController")
@ViewScoped
public class ListarPartidoController implements Serializable{

    @EJB
    private PartidoFacadeLocal pfl;
    private List<Partido> partidos;
    
    public ListarPartidoController() {
    }
    
    @PostConstruct
    public void init(){
        partidos = pfl.findAll();
    }

    public List<Partido> getPartidos() {
        return partidos;
    }
    
    
    
}
