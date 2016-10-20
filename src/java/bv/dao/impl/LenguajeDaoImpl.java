/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.dao.LenguajeDao;
import bv.util.sql;
import java.util.ArrayList;
import java.util.List;
import vb.entidad.Lenguaje;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class LenguajeDaoImpl implements LenguajeDao{
    
    sql conector = new sql();
    
    @Override
    public List<Lenguaje> listarSerieIdDocumental(String idDocumental) {
        String[] parametros = new String[1];
        parametros[0] = idDocumental;
        List<Object[]> listaIn = conector.execProcedure("BV.SP_LISTAR_LENGUAJE_ID_DOCUMENTAL", parametros);
        ArrayList<Lenguaje> lista = new ArrayList<>();
        for (Object[] dato : listaIn) {
            Lenguaje lenguaje = new Lenguaje();
            lenguaje.setID_LENGUAJE(dato[0].toString());
            lenguaje.setLENGUAJE(dato[1].toString());
            lista.add(lenguaje);
        }
        return lista;
    }
    
}
