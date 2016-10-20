/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.dao.*;
import static bv.util.Constantes.*;

/**
 *
 * @author virtual
 */
public class DaoFactory {

    private DaoFactory() {
    }

    public AudienciaDao getAudienciaDao(int tipo) {
        AudienciaDao dao;
        switch (tipo) {
            case AUDIENCIA:
                dao = new AudienciaDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }

    public AutorDao getAutorDao(int tipo) {
        AutorDao dao;
        switch (tipo) {
            case AUTOR:
                dao = new AutorDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }

    public BibliotecaDao getBibliotecaDao(int tipo) {
        BibliotecaDao dao;
        switch (tipo) {
            case BIBLIOTECA:
                dao = new BibliotecaDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }
    
    public ColeccionDao getColeccionDao(int tipo) {
        ColeccionDao dao;
        switch (tipo) {
            case COLECCION:
                dao = new ColeccionDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }

    public ComentarioDao getComentarioDao(int tipo) {
        ComentarioDao dao;
        switch (tipo) {
            case COMENTARIO:
                dao = new ComentarioDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }

    public ContribuidorDao getContribuidorDao(int tipo) {
        ContribuidorDao dao;
        switch (tipo) {
            case CONTRIBUIDOR:
                dao = new ContribuidorDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }

    public DocumentalDao getDocumentalDao(int tipo) {
        DocumentalDao dao;
        switch (tipo) {
            case DOCUMENTAL:
                dao = new DocumentalDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }

    public EspacialDao getEspacialDao(int tipo) {
        EspacialDao dao;
        switch (tipo) {
            case ESPACIAL:
                dao = new EspacialDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }

    public LenguajeDao getLenguajeDao(int tipo) {
        LenguajeDao dao;
        switch (tipo) {
            case LENGUAJE:
                dao = new LenguajeDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }
    
    public NovedadDao getNovedadDao(int tipo) {
        NovedadDao dao;
        switch (tipo) {
            case NOVEDAD:
                dao = new NovedadDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }

    public SerieDao getSerieDao(int tipo) {
        SerieDao dao;
        switch (tipo) {
            case SERIE:
                dao = new SerieDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }

    public TemaDao getTemaDao(int tipo) {
        TemaDao dao;
        switch (tipo) {
            case TEMA:
                dao = new TemaDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }
    
    public TemporalDao getTemporalDao(int tipo) {
        TemporalDao dao;
        switch (tipo) {
            case TEMPORAL:
                dao = new TemporalDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }
    
    public TipoDao getTipoDao(int tipo) {
        TipoDao dao;
        switch (tipo) {
            case TIPO:
                dao = new TipoDaoImpl();
                break;
            default:
                dao = null;
        }
        return dao;
    }

    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }

    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
    }
}
