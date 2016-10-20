/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.bean;

import bv.dao.EspacialDao;
import bv.dao.impl.DaoFactory;
import static bv.util.Constantes.ESPACIAL;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vb.entidad.Cobertura;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
@ManagedBean
@RequestScoped
public class espacialBean {

    private Cobertura espacial;
    private final EspacialDao eDao;
    private List<Cobertura> espaciales = new ArrayList<>();
    private List<Cobertura> cespaciales = new ArrayList<>();
    
    public espacialBean() {
        espacial = new Cobertura();
        DaoFactory factory = DaoFactory.getInstance();
        eDao = factory.getEspacialDao(ESPACIAL);
    }

    public Cobertura getEspacial() {
        return espacial;
    }

    public void setEspacial(Cobertura espacial) {
        this.espacial = espacial;
    }

    public List<Cobertura> getEspaciales() {
        espaciales = eDao.listEspacial();
        return espaciales;
    }

    public void setEspaciales(List<Cobertura> espaciales) {
        this.espaciales = espaciales;
    }

    public List<Cobertura> getCespaciales() {
        long startTimeBib = System.currentTimeMillis();
        cespaciales = eDao.conteoEspacial();
        long endTimeBib = System.currentTimeMillis();
        System.out.println("Conteo espaciales " + (endTimeBib - startTimeBib) / 1000 + " segundos");
        return cespaciales;
    }

    public void setCespaciales(List<Cobertura> cespaciales) {
        this.cespaciales = cespaciales;
    }
}
