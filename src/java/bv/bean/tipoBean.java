/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.bean;

import bv.dao.TipoDao;
import bv.dao.impl.DaoFactory;
import bv.dao.impl.TipoDaoImpl;
import static bv.util.Constantes.TIPO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vb.entidad.Tipo;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
@ManagedBean
@RequestScoped
public class tipoBean {

    private Tipo tipo;
    private final TipoDao tDao;
    private List<Tipo> tipos = new ArrayList<>();
    private List<Tipo> ctipos = new ArrayList<>();
    public tipoBean() {
        tipo = new Tipo();
        DaoFactory factory = DaoFactory.getInstance();
        tDao = factory.getTipoDao(TIPO);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

     public List<Tipo> getTipos() {
        tipos = tDao.listTipo();
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public List<Tipo> getCtipos() {
        long startTimeBib = System.currentTimeMillis();
        ctipos = tDao.conteoTipo();
        long endTimeBib = System.currentTimeMillis();
        System.out.println("Conteo ctipos " + (endTimeBib - startTimeBib) / 1000 + " segundos");
        return ctipos;
    }

    public void setCtipos(List<Tipo> ctipos) {
        this.ctipos = ctipos;
    }
    
}
