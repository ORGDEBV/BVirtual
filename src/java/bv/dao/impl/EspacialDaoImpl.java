/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.dao.EspacialDao;
import bv.util.sql;
import java.util.ArrayList;
import java.util.List;
import vb.entidad.Cobertura;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class EspacialDaoImpl implements EspacialDao {

    sql conector = new sql();

    @Override
    public List<Cobertura> listEspacial() {
        List<Cobertura> lEspacial = new ArrayList<>();
        String[] parametros = new String[0];
        List<Object[]> data = conector.execProcedure("BV.SP_LISTAR_PAIS_REGISTRADO", parametros);
        for (Object[] datos : data) {
            Cobertura cobertura = new Cobertura();
            cobertura.setID_PAIS(datos[0].toString());
            cobertura.setCOBERTURA_ESPACIAL(datos[1].toString());
            lEspacial.add(cobertura);
        }
        return lEspacial;
    }

    @Override
    public List<Cobertura> filtraEspacial(String filtroFinal) {
        List<Cobertura> lEspacial = new ArrayList<>();
        String[] parametros = new String[1];
        parametros[0] = filtroFinal;
        List<Object[]> data = conector.execProcedure("BV.SP_FILTRA_FILTRO_ESPACIAL", parametros);
        for (Object[] datos : data) {
            Cobertura cobertura = new Cobertura();
            cobertura.setID_PAIS(datos[0].toString());
            cobertura.setCOBERTURA_ESPACIAL(datos[1].toString());
            lEspacial.add(cobertura);
        }
        return lEspacial;
    }

    @Override
    public List<Cobertura> conteoEspacial() {
        List<Cobertura> lEspacial = new ArrayList<>();
        String[] parametros = new String[0];
        List<Object[]> data = conector.execProcedure("BV.SP_LISTAR_CONTEO_LUGARES", parametros);
        for (Object[] datos : data) {
            Cobertura cobertura = new Cobertura();
            cobertura.setID_PAIS(datos[0].toString());
            String COBERTURA = "";
            String[] palabras = datos[1].toString().split(" ");
            for (int i = 0; i < palabras.length; i++) {
                COBERTURA = COBERTURA + palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1).toLowerCase() + " ";
            }
            cobertura.setCOBERTURA_ESPACIAL(COBERTURA);
            cobertura.setCONTEO(Integer.parseInt(datos[2].toString()));
            lEspacial.add(cobertura);
        }
        return lEspacial;
    }

}
