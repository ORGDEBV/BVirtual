/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.dao.TemaDao;
import bv.util.sql;
import java.util.ArrayList;
import java.util.List;
import vb.entidad.Tema;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class TemaDaoImpl implements TemaDao {

    sql conector = new sql();

    @Override
    public List<Tema> listarSerieIdDocumental(String idDocumental) {
        String[] parametros = new String[1];
        parametros[0] = idDocumental;
        List<Object[]> listaIn = conector.execProcedure("BV.SP_LISTAR_TEMAS_ID_DOCUMENTAL", parametros);
        ArrayList<Tema> lista = new ArrayList<>();
        for (Object[] dato : listaIn) {
            Tema tema = new Tema();
            tema.setID_TEMA(Integer.parseInt(dato[0].toString()));
            tema.setTEMA(dato[1].toString());
            lista.add(tema);
        }
        return lista;
    }

}
