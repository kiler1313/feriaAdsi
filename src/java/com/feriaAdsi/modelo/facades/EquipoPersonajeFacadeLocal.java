/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.facades;

import com.feriaAdsi.modelo.entities.EquipoPersonaje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author comapaq
 */
@Local
public interface EquipoPersonajeFacadeLocal {

    void create(EquipoPersonaje equipoPersonaje);

    void edit(EquipoPersonaje equipoPersonaje);

    void remove(EquipoPersonaje equipoPersonaje);

    EquipoPersonaje find(Object id);

    List<EquipoPersonaje> findAll();

    List<EquipoPersonaje> findRange(int[] range);

    int count();
    
}
