/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao.impl;

import bv.dao.DocumentalDao;
import bv.util.ConectaDb;
import bv.util.sql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vb.entidad.Documental;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class DocumentalDaoImpl implements DocumentalDao {

    sql conector = new sql();

    @Override
    public List<Documental> listDocumental(int limite) {
        List<Documental> lDocumental = new ArrayList<>();
        Connection cn = ConectaDb.getConnection();
        try {
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT TOP "+limite+" * FROM BV.VW_LISTAR_PUBLICACION");
            while (rs.next()) {
                Documental documental = new Documental();
                documental.setID_DOCUMENTAL(rs.getString(1));
                documental.setTITULO(rs.getString(2));
                documental.setTITULO_ALTERNATIVO(rs.getString(3));
                documental.setDESCRIPCION(rs.getString(4));
                documental.setRESUMEN(rs.getString(5));
                documental.setID_TIPO(rs.getInt(6));
                documental.setTIPO(rs.getString(7));
                documental.setID_BIBLIOTECA_FUENTE(rs.getInt(8));
                documental.setBIBLIOTECA_FUENTE(rs.getString(9));
                documental.setDISTRITO(rs.getString(10));
                documental.setPROVINCIA(rs.getString(11));
                documental.setTIENE_COMO_VERSION(rs.getString(12));
                documental.setES_PARTE_DE(rs.getString(13));
                documental.setTIENE_PARTE_DE(rs.getString(14));
                documental.setID_COBERTURA_ESPACIAL(rs.getInt(15));
                documental.setCOBERTURA_ESPACIAL(rs.getString(16));
                documental.setID_COBERTURA_TEMPORAL(rs.getInt(17));
                documental.setCOBERTURA_TEMPORAL(rs.getString(18));
                documental.setFECHA_DISPONIBLE(rs.getString(19));
                documental.setFECHA_PUBLICACION(rs.getString(20));
                documental.setFECHA_ACEPTACION(rs.getDate(21));
                documental.setFECHA_COPYRIGHT(rs.getDate(22));
                documental.setID_FORMATO(rs.getString(23));
                documental.setFORMATO(rs.getString(24));
                documental.setFORMATO_EXTENSION(rs.getString(25));
                documental.setFORMATO_MEDIO_DESCRIPCION(rs.getString(26));
                documental.setID_EDITORIAL(rs.getInt(27));
                documental.setEDITORIAL(rs.getString(28));
                documental.setDERECHO(rs.getString(29));
                documental.setDERECHO_ACCESO(rs.getString(30));
                documental.setID_AUDIENCIA(rs.getInt(31));
                documental.setAUDIENCIA(rs.getString(32));
                documental.setURL(rs.getString(33));
                documental.setISBN(rs.getString(34));
                documental.setOTRO(rs.getString(35));
                documental.setNUMERO_PAGINAS(rs.getString(36));
                String autores = rs.getString(37);
                autores = autores.substring(0, autores.length() - 1);
                documental.setAUTORES(autores);
                documental.setID_PERFIL(rs.getInt(38));
                documental.setPERFIL(rs.getString(39));
                documental.setLOGOTIPO(rs.getString(40));
                int nroVisitas = Integer.parseInt(rs.getString(41));
                if (nroVisitas < 101) {
                    nroVisitas = 1;
                } else if (nroVisitas < 201) {
                    nroVisitas = 2;
                } else if (nroVisitas < 301) {
                    nroVisitas = 3;
                } else if (nroVisitas < 401) {
                    nroVisitas = 4;
                } else {
                    nroVisitas = 5;
                }
                documental.setNRO_VISITAS(nroVisitas);
                lDocumental.add(documental);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentalDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lDocumental;
    }

    @Override
    public Documental findDocumental(String idDocumental) {
        Documental documental = null;
        String[] array = new String[1];
        array[0] = idDocumental;
        ArrayList<Object[]> data = conector.execProcedure("BV.SP_LISTAR_DOCUMENTAL_ID", array);
        for (Object[] datos : data) {
            documental = new Documental();
            documental.setID_DOCUMENTAL(datos[0].toString());
            documental.setTITULO(datos[1].toString());
            documental.setTITULO_ALTERNATIVO(datos[2].toString());
            documental.setDESCRIPCION(datos[3].toString());
            documental.setRESUMEN(datos[4].toString());
            documental.setID_TIPO(Integer.parseInt(datos[5].toString()));
            documental.setTIPO(datos[6].toString());
            documental.setID_BIBLIOTECA_FUENTE(Integer.parseInt(datos[7].toString()));
            documental.setBIBLIOTECA_FUENTE(datos[8].toString());
            documental.setDISTRITO(datos[9].toString());
            documental.setPROVINCIA(datos[10].toString());
            documental.setTIENE_COMO_VERSION(datos[11].toString());
            documental.setES_PARTE_DE(datos[12].toString());
            documental.setTIENE_PARTE_DE(datos[13].toString());
            documental.setID_COBERTURA_ESPACIAL(Integer.parseInt(datos[14].toString()));
            documental.setCOBERTURA_ESPACIAL(datos[15].toString());
            documental.setID_COBERTURA_TEMPORAL(Integer.parseInt(datos[16].toString()));
            documental.setCOBERTURA_TEMPORAL(datos[17].toString());
            documental.setFECHA_DISPONIBLE(datos[18].toString());
            documental.setFECHA_PUBLICACION(datos[19].toString());
            documental.setFECHA_ACEPTACION((Date) datos[20]);
            documental.setFECHA_COPYRIGHT((Date) datos[21]);
            documental.setID_FORMATO(datos[22].toString());
            documental.setFORMATO(datos[23].toString());
            documental.setFORMATO_EXTENSION(datos[24].toString());
            documental.setFORMATO_MEDIO_DESCRIPCION(datos[25].toString());
            documental.setID_EDITORIAL(Integer.parseInt(datos[26].toString()));
            documental.setEDITORIAL(datos[27].toString());
            documental.setDERECHO(datos[28].toString());
            documental.setDERECHO_ACCESO(datos[29].toString());
            documental.setID_AUDIENCIA(Integer.parseInt(datos[30].toString()));
            documental.setAUDIENCIA(datos[31].toString());
            documental.setURL(datos[32].toString());
            documental.setISBN(datos[33].toString());
            documental.setOTRO(datos[34].toString());
            documental.setNUMERO_PAGINAS(datos[35].toString());
            documental.setID_PERFIL(Integer.parseInt(datos[36].toString()));
            documental.setNOTA(datos[37].toString());
            documental.setDIRECCION(datos[38].toString());
            documental.setDISTRITO(datos[39].toString());
            documental.setPROVINCIA(datos[40].toString());
            documental.setREGION(datos[41].toString());
            documental.setTITULO_MAPA(datos[42].toString());
            documental.setLATITUD(datos[43].toString());
            documental.setLONGITUD(datos[44].toString());
        }
        return documental;
    }

    @Override
    public List<Documental> buscaDocumental(String busqueda, int indicador) {
        List<Documental> lDocumental = new ArrayList<>();
        String[] array = new String[2];
        array[0] = busqueda;
        array[1] = indicador + "";
        ArrayList<Object[]> data = conector.execProcedure("BV.SP_FILTRAR_PUBLICACION", array);
        for (Object[] datos : data) {
            Documental documental = new Documental();
            documental.setID_DOCUMENTAL(datos[0].toString());
            documental.setTITULO(datos[1].toString());
            documental.setTITULO_ALTERNATIVO(datos[2].toString());
            documental.setDESCRIPCION(datos[3].toString());
            documental.setRESUMEN(datos[4].toString());
            documental.setID_TIPO(Integer.parseInt(datos[5].toString()));
            documental.setTIPO(datos[6].toString());
            documental.setID_BIBLIOTECA_FUENTE(Integer.parseInt(datos[7].toString()));
            documental.setBIBLIOTECA_FUENTE(datos[8].toString());
            documental.setDISTRITO(datos[9].toString());
            documental.setPROVINCIA(datos[10].toString());
            documental.setTIENE_COMO_VERSION(datos[11].toString());
            documental.setES_PARTE_DE(datos[12].toString());
            documental.setTIENE_PARTE_DE(datos[13].toString());
            documental.setID_COBERTURA_ESPACIAL(Integer.parseInt(datos[14].toString()));
            documental.setCOBERTURA_ESPACIAL(datos[15].toString());
            documental.setID_COBERTURA_TEMPORAL(Integer.parseInt(datos[16].toString()));
            documental.setCOBERTURA_TEMPORAL(datos[17].toString());
            documental.setFECHA_DISPONIBLE(datos[18].toString());
            documental.setFECHA_PUBLICACION(datos[19].toString());
            documental.setFECHA_ACEPTACION((Date) datos[20]);
            documental.setFECHA_COPYRIGHT((Date) datos[21]);
            documental.setID_FORMATO(datos[22].toString());
            documental.setFORMATO(datos[23].toString());
            documental.setFORMATO_EXTENSION(datos[24].toString());
            documental.setFORMATO_MEDIO_DESCRIPCION(datos[25].toString());
            documental.setID_EDITORIAL(Integer.parseInt(datos[26].toString()));
            documental.setEDITORIAL(datos[27].toString());
            documental.setDERECHO(datos[28].toString());
            documental.setDERECHO_ACCESO(datos[29].toString());
            documental.setID_AUDIENCIA(Integer.parseInt(datos[30].toString()));
            documental.setAUDIENCIA(datos[31].toString());
            documental.setURL(datos[32].toString());
            documental.setISBN(datos[33].toString());
            documental.setOTRO(datos[34].toString());
            documental.setNUMERO_PAGINAS(datos[35].toString());
            String autores = datos[36].toString();
            autores = autores.substring(0, autores.length() - 1);
            documental.setAUTORES(autores);
            documental.setID_PERFIL(Integer.parseInt(datos[37].toString()));
            documental.setPERFIL(datos[38].toString());
            documental.setLOGOTIPO(datos[39].toString());
            int nroVisitas = Integer.parseInt(datos[40].toString());
            if (nroVisitas < 101) {
                nroVisitas = 1;
            } else if (nroVisitas < 201) {
                nroVisitas = 2;
            } else if (nroVisitas < 301) {
                nroVisitas = 3;
            } else if (nroVisitas < 401) {
                nroVisitas = 4;
            } else {
                nroVisitas = 5;
            }
            documental.setNRO_VISITAS(nroVisitas);
            lDocumental.add(documental);
        }
        return lDocumental;
    }

    @Override
    public Object[] masVisto(String Accion) {
        Object[] masVista = null;
        String[] parametros = {"", "", Accion};
        ArrayList<Object[]> data = conector.execProcedure("BV.SP_PUBLICACION_MASVISTOS", parametros);
        for (Object[] obj : data) {
            masVista = obj;
        }
        return masVista;
    }

    @Override
    public void aumentarVisita(String ID_DOCUMENTAL) {
        String[] parametros = new String[1];
        parametros[0] = ID_DOCUMENTAL;
        conector.execProcedure("BV.SP_AUMENTAR_NRO_VISITAS", parametros);
    }
}
