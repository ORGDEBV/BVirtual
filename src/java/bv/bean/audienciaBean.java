/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.bean;

import bv.dao.AudienciaDao;
import bv.dao.impl.DaoFactory;
import static bv.util.Constantes.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vb.entidad.Audiencia;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
@ManagedBean
@RequestScoped
public class audienciaBean {

    Integer rating = 3;
    private Audiencia audiencia;
    private final AudienciaDao aDao;
    private List<Audiencia> audiencias = new ArrayList<>();
    private List<Audiencia> caudiencias = new ArrayList<>();
    
    public audienciaBean() {
        audiencia = new Audiencia();
        DaoFactory factory = DaoFactory.getInstance();
        aDao = factory.getAudienciaDao(AUDIENCIA);
    }

    public Audiencia getAudiencia() {
        return audiencia;
    }

    public void setAudiencia(Audiencia audiencia) {
        this.audiencia = audiencia;
    }

    public List<Audiencia> getAudiencias() {
        audiencias = aDao.listAudiencia();
        return audiencias;
    }

    public void setAudiencias(List<Audiencia> audiencias) {
        this.audiencias = audiencias;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<Audiencia> getCaudiencias() {
        long startTimeBib = System.currentTimeMillis();
        caudiencias = aDao.conteoAudiencia();
        long endTimeBib = System.currentTimeMillis();
        System.out.println("Conteo caudiencias " + (endTimeBib - startTimeBib) / 1000 + " segundos");
        return caudiencias;
    }

    public void setCaudiencias(List<Audiencia> caudiencias) {
        this.caudiencias = caudiencias;
    }
}
