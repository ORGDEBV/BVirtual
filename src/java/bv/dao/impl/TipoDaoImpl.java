/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.dao.TipoDao;
import bv.util.sql;
import java.util.ArrayList;
import java.util.List;
import vb.entidad.Tipo;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class TipoDaoImpl implements TipoDao{
    
    sql conector = new sql();
    
    @Override
    public List<Tipo> listTipo(){
        List<Tipo> lTipo = new ArrayList<>();
        String[] parametros = new String[0];
        List<Object[]> data = conector.execProcedure("BV.SP_LISTAR_TIPO_REGISTRADO", parametros);
        for (Object[] datos : data) {
            Tipo tipo = new Tipo();
            tipo.setID_TIPO(Integer.parseInt(datos[0].toString()));
            tipo.setTIPO(datos[1].toString());
            lTipo.add(tipo);
        }
        return lTipo;
    }
    
    @Override
    public List<Tipo> filtraTipo(String filtroFinal){
        List<Tipo> lTipo = new ArrayList<>();
        String[] parametros = new String[1];
        parametros[0] = filtroFinal;
        List<Object[]> data = conector.execProcedure("BV.SP_FILTRA_FILTRO_TIPO", parametros);
        for (Object[] datos : data) {
            Tipo tipo = new Tipo();
            tipo.setID_TIPO(Integer.parseInt(datos[0].toString()));
            tipo.setTIPO(datos[1].toString());
            lTipo.add(tipo);
        }
        return lTipo;
    }
    
    @Override
    public List<Tipo> conteoTipo(){
        List<Tipo> lTipo = new ArrayList<>();
        String[] parametros = new String[0];
        List<Object[]> data = conector.execProcedure("BV.SP_LISTAR_CONTEO_TIPOS", parametros);
        for (Object[] datos : data) {
            Tipo tipo = new Tipo();
            tipo.setID_TIPO(Integer.parseInt(datos[0].toString()));
            tipo.setTIPO(datos[1].toString());
            tipo.setCONTEO(Integer.parseInt(datos[2].toString()));
            lTipo.add(tipo);
        }
        return lTipo;
    }
    
}
