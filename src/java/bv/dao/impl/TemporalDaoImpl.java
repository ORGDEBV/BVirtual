/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.dao.TemporalDao;
import bv.util.sql;
import java.util.ArrayList;
import java.util.List;
import vb.entidad.CoberturaTemporal;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class TemporalDaoImpl implements TemporalDao{
    
    sql conector = new sql();
    
    @Override
    public List<CoberturaTemporal> listTemporal(){
        List<CoberturaTemporal> lTemporal = new ArrayList<>();
        String[] parametros = new String[0];
        List<Object[]> data = conector.execProcedure("BV.SP_LISTAR_TEMPORAL_REGISTRADO", parametros);
        for (Object[] datos : data) {
            CoberturaTemporal temporal = new CoberturaTemporal();
            temporal.setID_COBERTURA_TEMPORAL(Integer.parseInt(datos[0].toString()));
            temporal.setDESCRIPCION(datos[1].toString());
            lTemporal.add(temporal);
        }
        return lTemporal;
    }
    
    @Override
    public List<CoberturaTemporal> filtraTemporal(String filtroFinal){
        List<CoberturaTemporal> lTemporal = new ArrayList<>();
        String[] parametros = new String[1];
        parametros[0] = filtroFinal;
        List<Object[]> data = conector.execProcedure("BV.SP_FILTRA_FILTRO_TEMPORAL", parametros);
        for (Object[] datos : data) {
            CoberturaTemporal temporal = new CoberturaTemporal();
            temporal.setID_COBERTURA_TEMPORAL(Integer.parseInt(datos[0].toString()));
            temporal.setDESCRIPCION(datos[1].toString());
            lTemporal.add(temporal);
        }
        return lTemporal;
    }
    
    @Override
    public List<CoberturaTemporal> conteoTemporal(){
        List<CoberturaTemporal> lTemporal = new ArrayList<>();
        String[] parametros = new String[0];
        List<Object[]> data = conector.execProcedure("BV.SP_LISTAR_CONTEO_FECHAS", parametros);
        for (Object[] datos : data) {
            CoberturaTemporal temporal = new CoberturaTemporal();
            temporal.setID_COBERTURA_TEMPORAL(Integer.parseInt(datos[0].toString()));
            temporal.setDESCRIPCION(datos[1].toString());
            temporal.setCONTEO(Integer.parseInt(datos[2].toString()));
            lTemporal.add(temporal);
        }
        return lTemporal;
    }
    
}
