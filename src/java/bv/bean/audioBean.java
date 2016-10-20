/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.bean;

import bv.dao.DocumentalDao;
import bv.dao.impl.DaoFactory;
import static bv.util.Constantes.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author virtual
 */
@ManagedBean
@ViewScoped
public class audioBean {

    String cancion = "";
    String id = "";
    private final DocumentalDao docDao;
    Object[] mvAudios;

    public audioBean() {
        DaoFactory factory = DaoFactory.getInstance();
        docDao = factory.getDocumentalDao(DOCUMENTAL);
        mvAudios = docDao.masVisto("AUDIOS");
    }

    public void listaCanciones() {
        String id2 = id;
        // RequestContext.getCurrentInstance().execute("cambiarCanciones('"+canciones+"');");
    }

    public Object[] getMvAudios() {
        return mvAudios;
    }

    public void setMvAudios(Object[] mvAudios) {
        this.mvAudios = mvAudios;
    }

    public String getCancion() {
        cancion = mvAudios[1].toString();
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
