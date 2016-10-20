/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao;

import java.util.List;
import vb.entidad.Documental;

/**
 *
 * @author virtual
 */
public interface DocumentalDao {
    
    List<Documental> listDocumental(int limite);
    Documental findDocumental(String idDocumental);
    List<Documental> buscaDocumental(String busqueda, int indicador);
    Object[] masVisto(String Accion);
    void aumentarVisita(String ID_DOCUMENTAL);
    
}
