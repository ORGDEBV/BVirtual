/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.bean;

import bv.dao.NovedadDao;
import bv.dao.impl.DaoFactory;
import static bv.util.Constantes.NOVEDAD;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import vb.entidad.ImagenNovedad;
import vb.entidad.Novedad;

/**
 *
 * @author virtual
 */
@ManagedBean
@ViewScoped
public class novedadDetalleBean implements Serializable {

    private final NovedadDao novedadDao;
    private Novedad novedad;
    //ImagenNovedad imagenNovedad = new ImagenNovedad();
    private ArrayList<ImagenNovedad> lstImagenes;
    private ArrayList<Novedad> lstNovedadesUltimas;
    String idNovedadselect = "1";
    String id = "1";
    int n = 0;

    int numeroImagenes = 0;
    String strCarruselVisible = "true";
    boolean carruselVisible = true;

    public novedadDetalleBean() {
        lstImagenes = new ArrayList<>();
        DaoFactory factory = DaoFactory.getInstance();
        novedadDao = factory.getNovedadDao(NOVEDAD);
        lstNovedadesUltimas = new ArrayList<>();
        lstNovedadesUltimas = novedadDao.lisNovedadUltimas();
    }

    public void loadNovedadDetalle() {
        if (idNovedadselect != null) {
            novedad = novedadDao.Novedad_vistaDetalle(idNovedadselect);
            lstImagenes = novedadDao.listImagenesSliderDetalle(idNovedadselect);
            carruselVisible = lstImagenes.size() > 1;
        }
    }

    public boolean vista() {
        boolean vista;
        vista = !lstImagenes.isEmpty();
//        if (lstImagenes.isEmpty()) {
//            vista = false;
//        } else {
//            vista = true;
//        }
        return vista;
    }

    public String getIdNovedadselect() {
        return idNovedadselect;
    }

    public void setIdNovedadselect(String idNovedadselect) {
        this.idNovedadselect = idNovedadselect;
    }

    public String getStrCarruselVisible() {
        return strCarruselVisible;
    }

    public void setStrCarruselVisible(String strCarruselVisible) {
        this.strCarruselVisible = strCarruselVisible;
    }

    public boolean isCarruselVisible() {
//        if (n == 0) {
//            numeroImagenes = lstImagenes.size();
//            if (numeroImagenes == 1) {
//                carruselVisible = false;
//            } else {
//                carruselVisible = true;
//            }
//            n++;
//        }

        return carruselVisible;
    }

    public void setCarruselVisible(boolean carruselVisible) {
        this.carruselVisible = carruselVisible;
    }
//@PostConstruct

    public ArrayList<ImagenNovedad> getLstImagenes() {
        return lstImagenes;
    }

    public void setLstImagenes(ArrayList<ImagenNovedad> lstImagenes) {
        this.lstImagenes = lstImagenes;
    }

    public Novedad getNovedad() {
        return novedad;
    }

    public void setNovedad(Novedad novedad) {
        this.novedad = novedad;
    }

    public ArrayList<Novedad> getLstNovedadesUltimas() {
        return lstNovedadesUltimas;
    }

    public void setLstNovedadesUltimas(ArrayList<Novedad> lstNovedadesUltimas) {
        this.lstNovedadesUltimas = lstNovedadesUltimas;
    }

}
