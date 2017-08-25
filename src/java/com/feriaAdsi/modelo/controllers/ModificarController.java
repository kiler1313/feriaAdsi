/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.controllers;

import com.feriaAdsi.modelo.entities.Inscripcion;
import com.feriaAdsi.modelo.entities.Partido;
import com.feriaAdsi.modelo.facade.util.MessageUtil;
import com.feriaAdsi.modelo.facades.InscripcionFacadeLocal;
import com.feriaAdsi.modelo.facades.PartidoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author cheswill
 */
@Named(value = "modificarController")
@SessionScoped
public class ModificarController implements Serializable {

    @EJB
    private PartidoFacadeLocal pfl;
    @EJB
    private InscripcionFacadeLocal ifl;

    private Inscripcion inscripcion;

    

    private Partido partidoSeleccionado;

    public ModificarController() {
    }

    public Partido getPartidoSeleccionado() {
        return partidoSeleccionado;
    }

    public void setPartidoSeleccionado(Partido partidoSeleccionado) {
        this.partidoSeleccionado = partidoSeleccionado;
    }

    public String preModificar(Partido p) {
        setPartidoSeleccionado(p);
        return "/actualizarPartido.xhtml?faces-redirect=true";
    }

    public void actulaizarDatos() {
        try {
            pfl.edit(partidoSeleccionado);
            MessageUtil.enviarMensajeInformacion("form-editar", "Actualización", "Los datos del usuarios se han actualizado correctamente.");
            if (partidoSeleccionado.getResultado1() > partidoSeleccionado.getResultado2()) {
                if (partidoSeleccionado.getJugador1() == ifl.find(partidoSeleccionado.getJugador1())) {
                    inscripcion.getIdInscripcion();
                    inscripcion.setGanador(1);
                    inscripcion.setPuntaje(3);
                    ifl.edit(inscripcion);
                }
            } else if (partidoSeleccionado.getResultado2() > partidoSeleccionado.getResultado1()) {

            }

        } catch (Exception e) {
            MessageUtil.enviarMensajeErrorGlobal("Error al modificar los datos del usuario", e.getStackTrace().toString());
        }
    }

}
