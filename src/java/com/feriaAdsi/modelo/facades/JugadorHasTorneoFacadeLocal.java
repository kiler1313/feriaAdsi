/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.facades;

import com.feriaAdsi.modelo.entities.JugadorHasTorneo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface JugadorHasTorneoFacadeLocal {

    void create(JugadorHasTorneo jugadorHasTorneo);

    void edit(JugadorHasTorneo jugadorHasTorneo);

    void remove(JugadorHasTorneo jugadorHasTorneo);

    JugadorHasTorneo find(Object id);

    List<JugadorHasTorneo> findAll();

    List<JugadorHasTorneo> findRange(int[] range);

    int count();
    
}
