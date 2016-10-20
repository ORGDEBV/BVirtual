package bv.dao.impl;

import bv.dao.NovedadDao;
import bv.util.sql;
import java.util.ArrayList;
import java.util.Date;
import vb.entidad.Novedad;
import vb.entidad.ImagenNovedad;

public class NovedadDaoImpl implements NovedadDao{

    sql conector = new sql();

    @Override
    public ArrayList<Novedad> lisNovedad() {
        ArrayList<Novedad> lstNovedades = new ArrayList<>();
        String[] parametros = new String[10];
        parametros[0] = "";
        parametros[1] = "";
        parametros[2] = "";
        parametros[3] = "";
        parametros[4] = "";
        parametros[5] = "";
        parametros[6] = "";
        parametros[7] = "";
        parametros[8] = "";
        parametros[9] = "LISTAR";
        ArrayList<Object[]> data = conector.execProcedure("[web].[SP_NOVEDADES_MANTENIMIENTO]", parametros);
        for (Object[] obj : data) {
            Novedad n = new Novedad();
            n.setID_NOVEDADES(obj[0].toString());
            n.setTITULO_CORTO(obj[1].toString());
            n.setTITULO_COMPLETO(obj[2].toString());
            n.setDESCRIPCION(obj[3].toString());
            n.setCONTENIDO(obj[4].toString());
            n.setFECHA_NOVEDAD((Date) obj[5]);
            n.setFECHA_REGISTRO((Date) obj[6]);
            n.setMOSTAR_INICIO(obj[7].toString());
            n.setACTIVO(obj[8].toString());
            lstNovedades.add(n);

        }
        return lstNovedades;
    }

    @Override
    public ArrayList<ImagenNovedad> listImagenesSliderDetalle(String idNovedad) {
        ArrayList<ImagenNovedad> lstImagenes = new ArrayList<>();
        String[] parametros = new String[10];
        parametros[0] = idNovedad;
        parametros[1] = "";
        parametros[2] = "";
        parametros[3] = "";
        parametros[4] = "";
        parametros[5] = "";
        parametros[6] = "";
        parametros[7] = "";
        parametros[8] = "";
        parametros[9] = "LISTAR_VISTA_IMAGEN_NOVEDAD_DETALLE";
        ArrayList<Object[]> data = conector.execProcedure("[web].[SP_NOVEDADES_MANTENIMIENTO]", parametros);
        for (Object[] obj : data) {
            ImagenNovedad im = new ImagenNovedad();
            im.setID_NOVEDAD(obj[0].toString());
            im.setURL_NOVEDAD(obj[1].toString());
            im.setORDEN(obj[2].toString());
            lstImagenes.add(im);
        }
        return lstImagenes;

    }

    @Override
    public ArrayList<Novedad> lisNovedad_vistaGeneral() {
        ArrayList<Novedad> lstNovedades = new ArrayList<>();
        String[] parametros = new String[10];
        parametros[0] = "";
        parametros[1] = "";
        parametros[2] = "";
        parametros[3] = "";
        parametros[4] = "";
        parametros[5] = "";
        parametros[6] = "";
        parametros[7] = "";
        parametros[8] = "";
        parametros[9] = "LISTAR_VISTA_NOVEDAD";
        ArrayList<Object[]> data = conector.execProcedure("[web].[SP_NOVEDADES_MANTENIMIENTO]", parametros);
        for (Object[] obj : data) {
            Novedad n = new Novedad();
            n.setID_NOVEDADES(obj[0].toString());
            n.setTITULO_CORTO(obj[1].toString());
            n.setDESCRIPCION(obj[2].toString());
            n.setDirImg2(obj[3].toString());
            n.setStrFechaNovedad(obj[4].toString());
            lstNovedades.add(n);

        }

        return lstNovedades;

    }

    @Override
    public ArrayList<Novedad> lisNovedadUltimas() {
        ArrayList<Novedad> lstNovedades = new ArrayList<>();
        String[] parametros = new String[10];
        parametros[0] = "";
        parametros[1] = "";
        parametros[2] = "";
        parametros[3] = "";
        parametros[4] = "";
        parametros[5] = "";
        parametros[6] = "";
        parametros[7] = "";
        parametros[8] = "";
        parametros[9] = "LISTAR_VISTA_NOVEDAD_DETALLE_ULTIMAS_NOVEDADES";
        ArrayList<Object[]> data = conector.execProcedure("[web].[SP_NOVEDADES_MANTENIMIENTO]", parametros);
        for (Object[] obj : data) {
            Novedad n = new Novedad();
            n.setID_NOVEDADES(obj[0].toString());
            n.setTITULO_CORTO(obj[1].toString());
            n.setDirImg2(obj[2].toString());
            lstNovedades.add(n);
        }

        return lstNovedades;

    }

    @Override
    public ArrayList<Novedad> lisNovedadUltimas_Inicio() {
        ArrayList<Novedad> lstNovedades = new ArrayList<>();
        String[] parametros = new String[10];
        parametros[0] = "";
        parametros[1] = "";
        parametros[2] = "";
        parametros[3] = "";
        parametros[4] = "";
        parametros[5] = "";
        parametros[6] = "";
        parametros[7] = "";
        parametros[8] = "";
        parametros[9] = "LISTAR_VISTA_INICIO_DETALLE_ULTIMAS_NOVEDADES";
        ArrayList<Object[]> data = conector.execProcedure("[web].[SP_NOVEDADES_MANTENIMIENTO]", parametros);
        for (Object[] obj : data) {
            Novedad n = new Novedad();
            n.setID_NOVEDADES(obj[0].toString());
            n.setTITULO_CORTO(obj[1].toString());
            n.setDirImg2(obj[2].toString());
            lstNovedades.add(n);
        }
        return lstNovedades;

    }

    @Override
    public Novedad Novedad_vistaDetalle(String idNovedad) {
        String[] parametros = new String[10];
        parametros[0] = idNovedad;
        parametros[1] = "";
        parametros[2] = "";
        parametros[3] = "";
        parametros[4] = "";
        parametros[5] = "";
        parametros[6] = "";
        parametros[7] = "";
        parametros[8] = "";
        parametros[9] = "LISTAR_VISTA_NOVEDAD_DETALLE";
        ArrayList<Object[]> data = conector.execProcedure("[web].[SP_NOVEDADES_MANTENIMIENTO]", parametros);
        Novedad n = new Novedad();
        for (Object[] obj : data) {
            n.setID_NOVEDADES(obj[0].toString());
            n.setStrFechaNovedad(obj[1].toString());
            n.setTITULO_COMPLETO(obj[2].toString());
            n.setCONTENIDO(obj[3].toString());
        }

        return n;

    }

}
