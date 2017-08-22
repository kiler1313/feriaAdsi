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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author APRENDIZ
 */
@Entity
@Table(name = "torneo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Torneo.findAll", query = "SELECT t FROM Torneo t"),
    @NamedQuery(name = "Torneo.findByIdtorneo", query = "SELECT t FROM Torneo t WHERE t.idtorneo = :idtorneo"),
    @NamedQuery(name = "Torneo.findByTipo", query = "SELECT t FROM Torneo t WHERE t.tipo = :tipo")})
public class Torneo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtorneo")
    private Integer idtorneo;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "torneo")
    private List<JugadorHasTorneo> jugadorHasTorneoList;

    public Torneo() {
    }

    public Torneo(Integer idtorneo) {
        this.idtorneo = idtorneo;
    }

    public Integer getIdtorneo() {
        return idtorneo;
    }

    public void setIdtorneo(Integer idtorneo) {
        this.idtorneo = idtorneo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<JugadorHasTorneo> getJugadorHasTorneoList() {
        return jugadorHasTorneoList;
    }

    public void setJugadorHasTorneoList(List<JugadorHasTorneo> jugadorHasTorneoList) {
        this.jugadorHasTorneoList = jugadorHasTorneoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtorneo != null ? idtorneo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Torneo)) {
            return false;
        }
        Torneo other = (Torneo) object;
        if ((this.idtorneo == null && other.idtorneo != null) || (this.idtorneo != null && !this.idtorneo.equals(other.idtorneo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.feriaAdsi.modelo.entities.Torneo[ idtorneo=" + idtorneo + " ]";
    }
    
}
