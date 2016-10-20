/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao;

import java.util.List;
import vb.entidad.Serie;

/**
 *
 * @author virtual
 */
public interface SerieDao {

    List<Serie> listarSerieIdDocumental(String idDocumental);

}
