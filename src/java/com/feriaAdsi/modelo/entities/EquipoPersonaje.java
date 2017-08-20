/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author comapaq
 */
@Entity
@Table(name = "equipospersonajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoPersonaje.findAll", query = "SELECT e FROM EquipoPersonaje e")
    , @NamedQuery(name = "EquipoPersonaje.findByIdEquiPer", query = "SELECT e FROM EquipoPersonaje e WHERE e.idEquiPer = :idEquiPer")
    , @NamedQuery(name = "EquipoPersonaje.findByNombreEquiPer", query = "SELECT e FROM EquipoPersonaje e WHERE e.nombreEquiPer = :nombreEquiPer")})
public class EquipoPersonaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEquiPer")
    private Long idEquiPer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreEquiPer")
    private String nombreEquiPer;
    @JoinColumn(name = "idJuego", referencedColumnName = "idJuego")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Juego idJuego;

    public EquipoPersonaje() {
    }

    public EquipoPersonaje(Long idEquiPer) {
        this.idEquiPer = idEquiPer;
    }

    public EquipoPersonaje(Long idEquiPer, String nombreEquiPer) {
        this.idEquiPer = idEquiPer;
        this.nombreEquiPer = nombreEquiPer;
    }

    public Long getIdEquiPer() {
        return idEquiPer;
    }

    public void setIdEquiPer(Long idEquiPer) {
        this.idEquiPer = idEquiPer;
    }

    public String getNombreEquiPer() {
        return nombreEquiPer;
    }

    public void setNombreEquiPer(String nombreEquiPer) {
        this.nombreEquiPer = nombreEquiPer;
    }

    public Juego getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Juego idJuego) {
        this.idJuego = idJuego;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquiPer != null ? idEquiPer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoPersonaje)) {
            return false;
        }
        EquipoPersonaje other = (EquipoPersonaje) object;
        if ((this.idEquiPer == null && other.idEquiPer != null) || (this.idEquiPer != null && !this.idEquiPer.equals(other.idEquiPer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.feriaAdsi.modelo.entities.EquipoPersonaje[ idEquiPer=" + idEquiPer + " ]";
    }
    
}
