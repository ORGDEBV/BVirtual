/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.bean;

import bv.dao.BibliotecaDao;
import bv.dao.impl.DaoFactory;
import static bv.util.Constantes.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vb.entidad.Biblioteca;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
@ManagedBean
@RequestScoped
public class bibliotecaBean {

    private Biblioteca biblioteca;
    private final BibliotecaDao bDao;
    private List<Biblioteca> bibliotecas = new ArrayList<>();
    private List<Biblioteca> cbibliotecas = new ArrayList<>();

    public bibliotecaBean() {
        biblioteca = new Biblioteca();
        DaoFactory factory = DaoFactory.getInstance();
        bDao = factory.getBibliotecaDao(BIBLIOTECA);
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<Biblioteca> getBibliotecas() {
        bibliotecas = bDao.listBiblioteca();
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    public List<Biblioteca> getCbibliotecas() {
        long startTimeBib = System.currentTimeMillis();
        cbibliotecas = bDao.conteoBiblioteca();
        long endTimeBib = System.currentTimeMillis();
        System.out.println("Conteo Bibliotecas " + (endTimeBib - startTimeBib) / 1000 + " segundos");
        return cbibliotecas;
    }

    public void setCbibliotecas(List<Biblioteca> cbibliotecas) {
        this.cbibliotecas = cbibliotecas;
    }

}
