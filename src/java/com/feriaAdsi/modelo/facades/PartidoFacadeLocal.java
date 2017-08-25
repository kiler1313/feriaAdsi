/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.facades;

import com.feriaAdsi.modelo.entities.Inscripcion;
import com.feriaAdsi.modelo.entities.Partido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface PartidoFacadeLocal {

    void create(Partido partido);

    void edit(Partido partido);

    void remove(Partido partido);

    Partido find(Object id);

    List<Partido> findAll();

    List<Partido> findRange(int[] range);

    int count();
    
    
}
