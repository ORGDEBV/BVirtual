/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.dao.ComentarioDao;
import bv.util.sql;
import java.util.ArrayList;
import vb.entidad.Comentario;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class ComentarioDaoImpl implements ComentarioDao{

    sql conector = new sql();
    
    @Override
    public int crearEntidad(Comentario comentario) {
        int n = 0;
        String[] parametros = new String[6];
        parametros[0] = "";
        parametros[1] = comentario.getNOMBRE();
        parametros[2] = comentario.getCORREO_ELECTRONICO();
        parametros[3] = comentario.getCOMENTARIO();
        parametros[4] = "";
        parametros[5] = "COMENTARIO_ADD";
        ArrayList<Object[]> data = conector.execProcedure("BV.SP_MANTENIMIENTO_COMENTARIO", parametros);
        for (Object[] dat : data) {
            if (dat[0].toString().equals("1")) {
                n = 1;
            }
        }
        return n;
    }

}
