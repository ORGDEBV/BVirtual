/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao;

import java.util.List;
import vb.entidad.CoberturaTemporal;

/**
 *
 * @author virtual
 */
public interface TemporalDao {
    
    List<CoberturaTemporal> listTemporal();
    List<CoberturaTemporal> filtraTemporal(String filtroFinal);
    List<CoberturaTemporal> conteoTemporal();
    
}
