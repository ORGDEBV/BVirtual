/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.dao.AutorDao;
import bv.util.sql;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import vb.entidad.Autor;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class AutorDaoImpl implements AutorDao, Serializable {

    sql conector = new sql();

    @Override
    public List<Autor> listarAutorIdDocumental(String idDocumental) {
        String[] parametros = new String[1];
        parametros[0] = idDocumental;
        List<Object[]> listaIn = conector.execProcedure("BV.SP_LISTAR_AUTOR_ID_DOCUMENTAL", parametros);
        ArrayList<Autor> lista = new ArrayList<>();
        for (Object[] dato : listaIn) {
            Autor aut = new Autor();
            aut.setID_AUTOR(Integer.parseInt(dato[0].toString()));
            aut.setNOMBRE(dato[1].toString());
            aut.setAPELLIDO_PATERNO(dato[2].toString());
            aut.setAPELLIDO_MATERNO(dato[3].toString());
            aut.setID_PAIS(dato[4].toString());
            aut.setPAIS(dato[5].toString());
            lista.add(aut);
        }
        return lista;
    }

}
