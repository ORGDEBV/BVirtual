/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.dao.BibliotecaDao;
import bv.util.sql;
import java.util.ArrayList;
import java.util.List;
import vb.entidad.Biblioteca;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class BibliotecaDaoImpl implements BibliotecaDao{
    
    sql conector = new sql();
    
    @Override
    public List<Biblioteca> listBiblioteca(){
        List<Biblioteca> lBiblioteca = new ArrayList<>();
        String[] parametros = new String[0];
        List<Object[]> data = conector.execProcedure("BV.SP_LISTAR_BIBLIOTECA", parametros);
        for (Object[] datos : data) {
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.setID_BIBLIOTECA_MEDIADOR(Integer.parseInt(datos[0].toString()));
            biblioteca.setNOMBRE_BIBLIOTECA(datos[1].toString());
            lBiblioteca.add(biblioteca);
        }
        return lBiblioteca;
    }
    
    @Override
    public List<Biblioteca> filtraBiblioteca(String filtroFinal){
        List<Biblioteca> lBiblioteca = new ArrayList<>();
        String[] parametros = new String[1];
        parametros[0] = filtroFinal;
        List<Object[]> data = conector.execProcedure("BV.SP_FILTRA_FILTRO_BIBLIOTECA", parametros);
        for (Object[] datos : data) {
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.setID_BIBLIOTECA_MEDIADOR(Integer.parseInt(datos[0].toString()));
            biblioteca.setNOMBRE_BIBLIOTECA(datos[1].toString());
            lBiblioteca.add(biblioteca);
        }
        return lBiblioteca;
    }
    
    @Override
    public List<Biblioteca> conteoBiblioteca() {
        List<Biblioteca> lBiblioteca = new ArrayList<>();
        String[] parametros = new String[0];
        List<Object[]> data = conector.execProcedure("BV.SP_LISTAR_CONTEO_BIBLIOTECAS", parametros);
        for (Object[] datos : data) {
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.setID_BIBLIOTECA_MEDIADOR(Integer.parseInt(datos[0].toString()));
            String DESCRIPCION = "";
            String[] palabras = datos[1].toString().split(" ");
            for (int i = 0; i < palabras.length; i++) {
                if (palabras[i].length() < 3) {
                    DESCRIPCION = DESCRIPCION + palabras[i].toLowerCase();
                } else {
                    DESCRIPCION = DESCRIPCION + palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1).toLowerCase() + " ";
                }
            }
            biblioteca.setNOMBRE_BIBLIOTECA(DESCRIPCION);
            biblioteca.setCONTEO(Integer.parseInt(datos[2].toString()));
            lBiblioteca.add(biblioteca);
        }
        return lBiblioteca;
    }
    
}
