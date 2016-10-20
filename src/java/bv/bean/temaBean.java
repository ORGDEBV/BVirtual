/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vb.entidad.Tema;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
@ManagedBean
@RequestScoped
public class temaBean {
    
    private final Tema tema;
    List<Tema> temas = new ArrayList<>();
    List<String> stemas = new ArrayList<>();

    public temaBean() {
        tema = new Tema();
    }

    public List<String> getStemas() {
        return stemas;
    }

    public void setStemas(List<String> stemas) {
        this.stemas = stemas;
    }
    
    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }
    
}
