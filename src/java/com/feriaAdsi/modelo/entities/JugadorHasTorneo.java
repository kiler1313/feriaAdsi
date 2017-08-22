/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author APRENDIZ
 */
@Entity
@Table(name = "jugadores_has_torneos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JugadorHasTorneo.findAll", query = "SELECT j FROM JugadorHasTorneo j"),
    @NamedQuery(name = "JugadorHasTorneo.findByIdjugadoresHasTorneos", query = "SELECT j FROM JugadorHasTorneo j WHERE j.idjugadoresHasTorneos = :idjugadoresHasTorneos"),
    @NamedQuery(name = "JugadorHasTorneo.findByGanadores", query = "SELECT j FROM JugadorHasTorneo j WHERE j.ganadores = :ganadores")})
public class JugadorHasTorneo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjugadores_has_torneos")
    private Integer idjugadoresHasTorneos;
    @Column(name = "ganadores")
    private Integer ganadores;
    @JoinColumn(name = "jugador", referencedColumnName = "documento")
    @ManyToOne(optional = false)
    private Jugador jugador;
    @JoinColumn(name = "torneo", referencedColumnName = "idtorneo")
    @ManyToOne(optional = false)
    private Torneo torneo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugador1")
    private List<Partido> partidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugador2")
    private List<Partido> partidoList1;

    public JugadorHasTorneo() {
    }

    public JugadorHasTorneo(Integer idjugadoresHasTorneos) {
        this.idjugadoresHasTorneos = idjugadoresHasTorneos;
    }

    public Integer getIdjugadoresHasTorneos() {
        return idjugadoresHasTorneos;
    }

    public void setIdjugadoresHasTorneos(Integer idjugadoresHasTorneos) {
        this.idjugadoresHasTorneos = idjugadoresHasTorneos;
    }

    public Integer getGanadores() {
        return ganadores;
    }

    public void setGanadores(Integer ganadores) {
        this.ganadores = ganadores;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    @XmlTransient
    public List<Partido> getPartidoList() {
        return partidoList;
    }

    public void setPartidoList(List<Partido> partidoList) {
        this.partidoList = partidoList;
    }

    @XmlTransient
    public List<Partido> getPartidoList1() {
        return partidoList1;
    }

    public void setPartidoList1(List<Partido> partidoList1) {
        this.partidoList1 = partidoList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjugadoresHasTorneos != null ? idjugadoresHasTorneos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JugadorHasTorneo)) {
            return false;
        }
        JugadorHasTorneo other = (JugadorHasTorneo) object;
        if ((this.idjugadoresHasTorneos == null && other.idjugadoresHasTorneos != null) || (this.idjugadoresHasTorneos != null && !this.idjugadoresHasTorneos.equals(other.idjugadoresHasTorneos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.feriaAdsi.modelo.entities.JugadorHasTorneo[ idjugadoresHasTorneos=" + idjugadoresHasTorneos + " ]";
    }
    
}
