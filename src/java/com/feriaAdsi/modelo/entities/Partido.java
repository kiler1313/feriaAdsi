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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author APRENDIZ
 */
@Entity
@Table(name = "partidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p"),
    @NamedQuery(name = "Partido.findByIdPartido", query = "SELECT p FROM Partido p WHERE p.idPartido = :idPartido"),
    @NamedQuery(name = "Partido.findByResultado1", query = "SELECT p FROM Partido p WHERE p.resultado1 = :resultado1"),
    @NamedQuery(name = "Partido.findByResultado2", query = "SELECT p FROM Partido p WHERE p.resultado2 = :resultado2")})
public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPartido")
    private Integer idPartido;
    @Column(name = "resultado1")
    private Integer resultado1;
    @Column(name = "resultado2")
    private Integer resultado2;
    @JoinColumn(name = "jugador1", referencedColumnName = "idInscripcion")
    @ManyToOne(optional = false)
    private Inscripcion jugador1;
    @JoinColumn(name = "jugador2", referencedColumnName = "idInscripcion")
    @ManyToOne(optional = false)
    private Inscripcion jugador2;

    public Partido() {
    }

    public Partido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public Integer getResultado1() {
        return resultado1;
    }

    public void setResultado1(Integer resultado1) {
        this.resultado1 = resultado1;
    }

    public Integer getResultado2() {
        return resultado2;
    }

    public void setResultado2(Integer resultado2) {
        this.resultado2 = resultado2;
    }

    public Inscripcion getJugador1() {
        return jugador1;
    }

    public void setJugador1(Inscripcion jugador1) {
        this.jugador1 = jugador1;
    }

    public Inscripcion getJugador2() {
        return jugador2;
    }

    public void setJugador2(Inscripcion jugador2) {
        this.jugador2 = jugador2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartido != null ? idPartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partido)) {
            return false;
        }
        Partido other = (Partido) object;
        if ((this.idPartido == null && other.idPartido != null) || (this.idPartido != null && !this.idPartido.equals(other.idPartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.feriaAdsi.modelo.entities.Partido[ idPartido=" + idPartido + " ]";
    }
    
}
