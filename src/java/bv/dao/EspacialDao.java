/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao;

import java.util.List;
import vb.entidad.Cobertura;

/**
 *
 * @author virtual
 */
public interface EspacialDao {
    
    List<Cobertura> listEspacial();
    List<Cobertura> filtraEspacial(String filtroFinal);
    List<Cobertura> conteoEspacial();
    
}
