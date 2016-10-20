package bv.bean;

import bv.dao.NovedadDao;
import bv.dao.impl.DaoFactory;
import static bv.util.Constantes.NOVEDAD;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import vb.entidad.Novedad;
import vb.entidad.ImagenNovedad;

@ManagedBean
@ViewScoped
public class novedadBean {

    private final NovedadDao novedadDao;
    private ArrayList<ImagenNovedad> lstImagenes = new ArrayList<>();
    private ArrayList<Novedad> lstNovedades;

    public novedadBean() {
        DaoFactory factory = DaoFactory.getInstance();
        novedadDao = factory.getNovedadDao(NOVEDAD);
        lstNovedades = novedadDao.lisNovedad_vistaGeneral();
    }

    public ArrayList<ImagenNovedad> getLstImagenes() {
        return lstImagenes;
    }

    public void setLstImagenes(ArrayList<ImagenNovedad> lstImagenes) {
        this.lstImagenes = lstImagenes;
    }

    public ArrayList<Novedad> getLstNovedades() {

        return lstNovedades;
    }

    public void setLstNovedades(ArrayList<Novedad> lstNovedades) {
        this.lstNovedades = lstNovedades;
    }

}
