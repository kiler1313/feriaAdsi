/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.facades;

import com.feriaAdsi.modelo.entities.Torneo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface TorneoFacadeLocal {

    void create(Torneo torneo);

    void edit(Torneo torneo);

    void remove(Torneo torneo);

    Torneo find(Object id);

    List<Torneo> findAll();

    List<Torneo> findRange(int[] range);

    int count();
    
    List<Torneo> findByTipo(String tipo);
    
}
