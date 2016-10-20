/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.bean;

import bv.dao.TemporalDao;
import bv.dao.impl.DaoFactory;
import static bv.util.Constantes.TEMPORAL;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vb.entidad.CoberturaTemporal;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
@ManagedBean
@RequestScoped
public class temporalBean {

    private CoberturaTemporal temporal;
    private final TemporalDao tDao;
    private List<CoberturaTemporal> temporales = new ArrayList<>();
    private List<CoberturaTemporal> ctemporales = new ArrayList<>();
    public temporalBean() {
        temporal = new CoberturaTemporal();
        DaoFactory factory = DaoFactory.getInstance();
        tDao = factory.getTemporalDao(TEMPORAL);
    }

    public CoberturaTemporal getTemporal() {
        return temporal;
    }

    public void setTemporal(CoberturaTemporal temporal) {
        this.temporal = temporal;
    }

    public List<CoberturaTemporal> getTemporales() {
        temporales = tDao.listTemporal();
        return temporales;
    }

    public void setTemporales(List<CoberturaTemporal> temporales) {
        this.temporales = temporales;
    }

    public List<CoberturaTemporal> getCtemporales() {
        long startTimeBib = System.currentTimeMillis();
        ctemporales = tDao.conteoTemporal();
        long endTimeBib = System.currentTimeMillis();
        System.out.println("Conteo ctemporales " + (endTimeBib - startTimeBib) / 1000 + " segundos");
        return ctemporales;
    }

    public void setCtemporales(List<CoberturaTemporal> ctemporales) {
        this.ctemporales = ctemporales;
    }
    
}
