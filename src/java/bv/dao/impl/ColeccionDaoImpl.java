/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.dao.ColeccionDao;
import bv.util.sql;
import java.util.ArrayList;
import java.util.List;
import vb.entidad.Coleccion;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class ColeccionDaoImpl implements ColeccionDao{

    sql conector = new sql();

    @Override
    public List<Coleccion> listColeccion() {
        List<Coleccion> lColeccion = new ArrayList<>();
        String[] parametros = new String[0];
        List<Object[]> data = conector.execProcedure("BV.SP_LISTAR_COLECCION", parametros);
        for (Object[] datos : data) {
            Coleccion coleccion = new Coleccion();
            coleccion.setID_COLECCION(Integer.parseInt(datos[0].toString()));
            coleccion.setDESCRIPCION(datos[2].toString());
            lColeccion.add(coleccion);
        }
        return lColeccion;
    }

    @Override
    public List<Coleccion> listarColeccionIdDocumental(String idDocumental) {
        String[] parametros = new String[1];
        parametros[0] = idDocumental;
        List<Object[]> listaIn = conector.execProcedure("BV.SP_LISTAR_COLECCION_ID_DOCUMENTAL", parametros);
        ArrayList<Coleccion> lista = new ArrayList<>();
        for (Object[] dato : listaIn) {
            Coleccion coleccion = new Coleccion();
            coleccion.setID_COLECCION(Integer.parseInt(dato[0].toString()));
            coleccion.setCOD_COLECCION(dato[1].toString());
            coleccion.setDESCRIPCION(dato[2].toString());
            lista.add(coleccion);
        }
        return lista;
    }

    @Override
    public List<Coleccion> filtraColeccion(String filtroFinal) {
        ArrayList<Coleccion> lista = new ArrayList<>();
        String[] parametros = new String[1];
        parametros[0] = filtroFinal;
        List<Object[]> listaIn = conector.execProcedure("BV.SP_FILTRA_FILTRO_COLECCION", parametros);
        for (Object[] dato : listaIn) {
            Coleccion coleccion = new Coleccion();
            coleccion.setID_COLECCION(Integer.parseInt(dato[0].toString()));
            coleccion.setCOD_COLECCION(dato[1].toString());
            coleccion.setDESCRIPCION(dato[2].toString());
            lista.add(coleccion);
        }

        return lista;
    }

    @Override
    public List<Coleccion> conteoColeccion() {
        List<Coleccion> lColeccion = new ArrayList<>();
        String[] parametros = new String[0];
        List<Object[]> data = conector.execProcedure("BV.SP_LISTAR_CONTEO_COLECCIONES", parametros);
        for (Object[] datos : data) {
            Coleccion coleccion = new Coleccion();
            coleccion.setID_COLECCION(Integer.parseInt(datos[0].toString()));
            String DESCRIPCION = "";
            String[] palabras = datos[1].toString().split(" ");
            for (int i = 0; i < palabras.length; i++) {
                if (palabras[i].length() < 3) {
                    DESCRIPCION = DESCRIPCION + palabras[i].toLowerCase();
                } else {
                    DESCRIPCION = DESCRIPCION + palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1).toLowerCase() + " ";
                }

            }
            coleccion.setDESCRIPCION(DESCRIPCION);
            coleccion.setCONTEO(Integer.parseInt(datos[2].toString()));
            lColeccion.add(coleccion);
        }
        return lColeccion;
    }

}
