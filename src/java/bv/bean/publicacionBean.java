/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.bean;

import bv.dao.DocumentalDao;
import bv.dao.impl.DaoFactory;
import static bv.util.Constantes.DOCUMENTAL;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class publicacionBean {

    private final DocumentalDao docDao;
    Object[] mvLibros;
    Object[] mvImagenes;
    Object[] mvRevistas;
    Object[] mvPeriodicos;
    Object[] mvVideos;
    Object[] mvAudios;
    Object[] mvCartas;
    Object[] mvManuscritos;
    Object[] mvMapas;
    Object[] mvPartituras;
    private String pagAudioMasVisto = "#";

    public publicacionBean() {
        DaoFactory factory = DaoFactory.getInstance();
        docDao = factory.getDocumentalDao(DOCUMENTAL);
        mvLibros = docDao.masVisto("LIBROS");
        mvImagenes = docDao.masVisto("IMAGENES");
        mvRevistas = docDao.masVisto("REVISTAS");
        mvPeriodicos = docDao.masVisto("PERIODICOS");
        mvVideos = docDao.masVisto("VIDEOS");
        mvAudios = docDao.masVisto("AUDIOS");
        mvCartas = docDao.masVisto("CARTAS");
        mvManuscritos = docDao.masVisto("MANUSCRITOS");
        mvMapas = docDao.masVisto("MAPAS");
        mvPartituras = docDao.masVisto("PARTITURAS");

    }

    public String getPagAudioMasVisto() {
        int n = Integer.parseInt(mvAudios[4].toString());
        switch (n) {
            case 19:
                pagAudioMasVisto = "/Bvirtual/Cassete";
                break;
            case 21:
                pagAudioMasVisto = "/Bvirtual/Vinilo";
            default:
                pagAudioMasVisto = "/Bvirtual/cd";
                break;
        }
        return pagAudioMasVisto;
    }

    public void setPagAudioMasVisto(String pagAudioMasVisto) {
        this.pagAudioMasVisto = pagAudioMasVisto;
    }

    public Object[] getMvLibros() {

        return mvLibros;
    }

    public void setMvLibros(Object[] mvLibros) {
        this.mvLibros = mvLibros;
    }

    public Object[] getMvImagenes() {
        return mvImagenes;
    }

    public void setMvImagenes(Object[] mvImagenes) {
        this.mvImagenes = mvImagenes;
    }

    public Object[] getMvRevistas() {
        return mvRevistas;
    }

    public void setMvRevistas(Object[] mvRevistas) {
        this.mvRevistas = mvRevistas;
    }

    public Object[] getMvPeriodicos() {
        return mvPeriodicos;
    }

    public void setMvPeriodicos(Object[] mvPeriodicos) {
        this.mvPeriodicos = mvPeriodicos;
    }

    public Object[] getMvVideos() {
        return mvVideos;
    }

    public void setMvVideos(Object[] mvVideos) {
        this.mvVideos = mvVideos;
    }

    public Object[] getMvAudios() {
        return mvAudios;
    }

    public void setMvAudios(Object[] mvAudios) {
        this.mvAudios = mvAudios;
    }

    public Object[] getMvCartas() {
        return mvCartas;
    }

    public void setMvCartas(Object[] mvCartas) {
        this.mvCartas = mvCartas;
    }

    public Object[] getMvManuscritos() {
        return mvManuscritos;
    }

    public void setMvManuscritos(Object[] mvManuscritos) {
        this.mvManuscritos = mvManuscritos;
    }

    public Object[] getMvMapas() {
        return mvMapas;
    }

    public void setMvMapas(Object[] mvMapas) {
        this.mvMapas = mvMapas;
    }

    public Object[] getMvPartituras() {
        return mvPartituras;
    }

    public void setMvPartituras(Object[] mvPartituras) {
        this.mvPartituras = mvPartituras;
    }

}
