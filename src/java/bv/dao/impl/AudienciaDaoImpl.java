/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.util.sql;
import java.util.ArrayList;
import java.util.List;
import vb.entidad.Audiencia;
import bv.dao.AudienciaDao;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class AudienciaDaoImpl implements AudienciaDao {

    sql conector = new sql();

    @Override
    public List<Audiencia> filtraAudiencia(String filroFinal) {
        List<Audiencia> lAudiencia = new ArrayList<>();
        String[] parametros = new String[1];
        parametros[0] = filroFinal;
        List<Object[]> data = conector.execProcedure("BV.SP_FILTRA_FILTRO_AUDIENCIA", parametros);
        for (Object[] datos : data) {
            Audiencia audiencia = new Audiencia();
            audiencia.setID_AUDIENCIA(Integer.parseInt(datos[0].toString()));
            audiencia.setAUDIENCIA(datos[1].toString());
            lAudiencia.add(audiencia);
        }
        return lAudiencia;
    }

    @Override
    public List<Audiencia> conteoAudiencia() {
        List<Audiencia> lAudiencia = new ArrayList<>();
        String[] parametros = new String[0];
        List<Object[]> data = conector.execProcedure("BV.SP_LISTAR_CONTEO_AUDIENCIAS", parametros);
        for (Object[] datos : data) {
            Audiencia audiencia = new Audiencia();
            audiencia.setID_AUDIENCIA(Integer.parseInt(datos[0].toString()));
            String DESCRIPCION = "";
            String[] palabras = datos[1].toString().split(" ");
            for (int i = 0; i < palabras.length; i++) {
                if (palabras[i].length() < 3) {
                    DESCRIPCION = DESCRIPCION + palabras[i].toLowerCase();
                } else {
                    DESCRIPCION = DESCRIPCION + palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1).toLowerCase() + " ";
                }

            }
            audiencia.setAUDIENCIA(DESCRIPCION);
            audiencia.setCONTEO(Integer.parseInt(datos[2].toString()));
            lAudiencia.add(audiencia);
        }
        return lAudiencia;
    }

    @Override
    public List<Audiencia> listAudiencia() {
        List<Audiencia> lAudiencia = new ArrayList<>();
        String[] parametros = new String[0];
        List<Object[]> data = conector.execProcedure("BV.SP_LISTAR_AUDIENCIA_REGISTRADO", parametros);
        for (Object[] datos : data) {
            Audiencia audiencia = new Audiencia();
            audiencia.setID_AUDIENCIA(Integer.parseInt(datos[0].toString()));
            audiencia.setAUDIENCIA(datos[1].toString());
            audiencia.setCONTEO(data.size());
            lAudiencia.add(audiencia);
        }
        return lAudiencia;
    }

}
