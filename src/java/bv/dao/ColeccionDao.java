/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao;

import java.util.List;
import vb.entidad.Coleccion;

/**
 *
 * @author virtual
 */
public interface ColeccionDao {
    
    List<Coleccion> listColeccion();
    List<Coleccion> listarColeccionIdDocumental(String idDocumental);
    List<Coleccion> filtraColeccion(String filtroFinal);
    List<Coleccion> conteoColeccion();
    
}
