/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao;

import java.util.List;
import vb.entidad.Autor;

/**
 *
 * @author virtual
 */
public interface AutorDao {
    
    List<Autor> listarAutorIdDocumental(String idDocumental);
    
}
