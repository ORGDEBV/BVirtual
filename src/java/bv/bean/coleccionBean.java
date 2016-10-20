/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.bean;

import bv.dao.ColeccionDao;
import bv.dao.impl.DaoFactory;
import static bv.util.Constantes.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vb.entidad.Coleccion;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
@ManagedBean
@RequestScoped
public class coleccionBean {

    private Coleccion coleccion;
    private final ColeccionDao cDao;
    private List<Coleccion> colecciones = new ArrayList<>();
    private List<Coleccion> ccolecciones = new ArrayList<>();

    public coleccionBean() {
        coleccion = new Coleccion();
        DaoFactory factory = DaoFactory.getInstance();
        cDao = factory.getColeccionDao(COLECCION);
    }

    public Coleccion getColeccion() {
        return coleccion;
    }

    public void setColeccion(Coleccion coleccion) {
        this.coleccion = coleccion;
    }

    public List<Coleccion> getColecciones() {
        colecciones = cDao.listColeccion();
        return colecciones;
    }

    public void setColecciones(List<Coleccion> colecciones) {
        this.colecciones = colecciones;
    }

    public List<Coleccion> getCcolecciones() {
        long startTimeBib = System.currentTimeMillis();
        ccolecciones = cDao.conteoColeccion();
        long endTimeBib = System.currentTimeMillis();
        System.out.println("Conteo colecciones " + (endTimeBib - startTimeBib) / 1000 + " segundos");
        return ccolecciones;
    }

    public void setCcolecciones(List<Coleccion> ccolecciones) {
        this.ccolecciones = ccolecciones;
    }

}
