/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.dao.SerieDao;
import bv.util.sql;
import java.util.ArrayList;
import java.util.List;
import vb.entidad.Serie;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class SerieDaoImpl implements SerieDao{
    
    sql conector = new sql();
    
    @Override
    public List<Serie> listarSerieIdDocumental(String idDocumental) {
        String[] parametros = new String[1];
        parametros[0] = idDocumental;
        List<Object[]> listaIn = conector.execProcedure("BV.SP_LISTAR_SERIE_ID_DOCUMENTAL", parametros);
        ArrayList<Serie> lista = new ArrayList<>();
        for (Object[] dato : listaIn) {
            Serie serie = new Serie();
            serie.setID_SERIE(Integer.parseInt(dato[0].toString()));
            serie.setSERIE(dato[1].toString());
            lista.add(serie);
        }
        return lista;
    }
    
}
