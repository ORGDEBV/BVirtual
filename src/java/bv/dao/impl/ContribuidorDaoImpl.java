/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.dao.ContribuidorDao;
import bv.util.sql;
import java.util.ArrayList;
import java.util.List;
import vb.entidad.Contribuidor;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class ContribuidorDaoImpl implements ContribuidorDao{
    
    sql conector = new sql();
    
    @Override
    public List<Contribuidor> listarContribuidorIdDocumental(String idDocumental) {
        String[] parametros = new String[1];
        parametros[0] = idDocumental;
        List<Object[]> listaIn = conector.execProcedure("BV.SP_LISTAR_CONTRIBUIDOR_ID_DOCUMENTAL", parametros);
        ArrayList<Contribuidor> lista = new ArrayList<>();
        for (Object[] dato : listaIn) {
            Contribuidor contribuidor = new Contribuidor();
            contribuidor.setID_CONTRIBUIDOR(Integer.parseInt(dato[0].toString()));
            contribuidor.setCONTRIBUIDOR(dato[1].toString());
            lista.add(contribuidor);
        }
        return lista;
    }
    
}
