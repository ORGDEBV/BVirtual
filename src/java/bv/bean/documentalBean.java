package bv.bean;

import bv.dao.AudienciaDao;
import bv.dao.AutorDao;
import bv.dao.BibliotecaDao;
import bv.dao.ColeccionDao;
import bv.dao.ContribuidorDao;
import bv.dao.DocumentalDao;
import bv.dao.EspacialDao;
import bv.dao.LenguajeDao;
import bv.dao.NovedadDao;
import bv.dao.SerieDao;
import bv.dao.TemaDao;
import bv.dao.TemporalDao;
import bv.dao.TipoDao;
import bv.dao.impl.DaoFactory;
import static bv.util.Constantes.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import vb.entidad.Audiencia;
import vb.entidad.Autor;
import vb.entidad.Biblioteca;
import vb.entidad.Cobertura;
import vb.entidad.CoberturaTemporal;
import vb.entidad.Coleccion;
import vb.entidad.Contribuidor;
import vb.entidad.Documental;
import vb.entidad.Lenguaje;
import vb.entidad.Novedad;
import vb.entidad.Serie;
import vb.entidad.Tema;
import vb.entidad.Tipo;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
@ManagedBean
@ViewScoped
public class documentalBean implements Serializable {

    //PAGINADOR EN DATASCROLLER
    int indicador = 1;

    //VARIABLE PARA SER USADA Y SER ENVIADA COMO PARAMETRO PARA SER MOSTRADA EN UNA PAGINA ADICIONAL
    private String ID_DOCUMENTAL;
    private Documental documental;

    private final NovedadDao novedadDao;
    private final DocumentalDao dDao;
    private final AutorDao aDao;
    private final ContribuidorDao cDao;
    private final SerieDao sDao;
    private final LenguajeDao lDao;
    private final TemaDao tDao;
    private ArrayList<Novedad> lstNovedades;
    //TRAER FILTROS DESDE OTRAS PAGINAS
    private int auxFiltros = 0;
    private String gidmaterial;
    private String gidbiblioteca;
    private String gidcoleccion;
    //ORDER BY
    private String campoOrder = "TITULO";
    private String ordenOrder = "ASC";
    private List<String> lConsulta = new ArrayList<>();
    private String buscador;
    private String buscadorMovil;
    private List<Documental> listdocumental = new ArrayList<>();
    private List<Autor> lautor = new ArrayList<>();
    private List<Contribuidor> lcontribuidor = new ArrayList<>();
    private List<Coleccion> lcoleccion = new ArrayList<>();
    private List<Serie> lserie = new ArrayList<>();
    private List<Lenguaje> llenguaje = new ArrayList<>();
    private List<Tema> ltema = new ArrayList<>();

    /////////////////////////////////////////////////////////////
    //////////////SELECCIÓN DE FILTROS///////////////////////////
    /////////////////////////////////////////////////////////////
    private List<String> sbiblioteca = new ArrayList<>();
    private List<String> csbiblioteca = new ArrayList<>();
    private List<String> scoleccion = new ArrayList<>();
    private List<String> cscoleccion = new ArrayList<>();
    private List<String> stipo = new ArrayList<>();
    private List<String> cstipo = new ArrayList<>();
    private List<String> sespacial = new ArrayList<>();
    private List<String> csespacial = new ArrayList<>();
    private List<String> stemporal = new ArrayList<>();
    private List<String> cstemporal = new ArrayList<>();
    private List<String> saudiencia = new ArrayList<>();
    private List<String> csaudiencia = new ArrayList<>();

    /////////////////////////////////////////////////////////////
    //////////////ARRAY DE CONSULTAS///////////////////////////
    /////////////////////////////////////////////////////////////
    private List<String> conBiblioteca = new ArrayList<>();
    private List<String> conColeccion = new ArrayList<>();
    private List<String> conTipo = new ArrayList<>();
    private List<String> conEspacial = new ArrayList<>();
    private List<String> conTemporal = new ArrayList<>();
    private List<String> conAudiencia = new ArrayList<>();
    private List<String> conBuscador = new ArrayList<>();

    /////////////////////////////////////////////////////////////
    //////////////LISTA DE BIBLIOTECAS///////////////////////////
    /////////////////////////////////////////////////////////////
    private Biblioteca biblioteca;
    private final BibliotecaDao biDao;
    private List<Biblioteca> bibliotecas = new ArrayList<>();

    /////////////////////////////////////////////////////////////
    //////////////LISTA DE COLECCIONES///////////////////////////
    /////////////////////////////////////////////////////////////
    private Coleccion coleccion;
    private final ColeccionDao coDao;
    private List<Coleccion> colecciones = new ArrayList<>();

    /////////////////////////////////////////////////////////////
    /////////////////////LISTA DE TIPOS//////////////////////////
    /////////////////////////////////////////////////////////////
    private Tipo tipo;
    private final TipoDao tiDao;
    List<Tipo> tipos = new ArrayList<>();

    /////////////////////////////////////////////////////////////
    //////////////////LISTA DE ESPACIAL//////////////////////////
    /////////////////////////////////////////////////////////////
    private Cobertura espacial;
    private final EspacialDao esDao;
    List<Cobertura> espaciales = new ArrayList<>();

    /////////////////////////////////////////////////////////////
    //////////////////LISTA DE TEMPORAL//////////////////////////
    /////////////////////////////////////////////////////////////
    private CoberturaTemporal temporal;
    private final TemporalDao teDao;
    List<CoberturaTemporal> temporales = new ArrayList<>();

    /////////////////////////////////////////////////////////////
    //////////////////LISTA DE TEMPORAL//////////////////////////
    /////////////////////////////////////////////////////////////
    private Audiencia audiencia;
    private final AudienciaDao auDao;
    List<Audiencia> audiencias = new ArrayList<>();

    /////////////////////////////////////////////////////////////
    //////////////////MAPAS//////////////////////////
    /////////////////////////////////////////////////////////////
    private MapModel emptyModel;

    public documentalBean() {
        long startTimeBib = System.currentTimeMillis();
        documental = new Documental();
        DaoFactory factory = DaoFactory.getInstance();
        dDao = factory.getDocumentalDao(DOCUMENTAL);
        aDao = factory.getAutorDao(AUTOR);
        cDao = factory.getContribuidorDao(CONTRIBUIDOR);
        sDao = factory.getSerieDao(SERIE);
        lDao = factory.getLenguajeDao(LENGUAJE);
        tDao = factory.getTemaDao(TEMA);
        novedadDao = factory.getNovedadDao(NOVEDAD);
        long endTimeBib = System.currentTimeMillis();
        System.out.println("constructor " + (endTimeBib - startTimeBib) / 1000 + " segundos");
        //listdocumental = dDao.listDocumental(limite);
        long startTimeBibnov = System.currentTimeMillis();
        lstNovedades = novedadDao.lisNovedadUltimas_Inicio();
        long endTimeBibnov = System.currentTimeMillis();
        System.out.println("novedades " + (endTimeBibnov - startTimeBibnov) / 1000 + " segundos");
        //////////////BIBLIOTECA///////////////////
        long startTimeBiblio = System.currentTimeMillis();
        biblioteca = new Biblioteca();
        biDao = factory.getBibliotecaDao(BIBLIOTECA);
        bibliotecas = biDao.listBiblioteca();
        long endTimeBiblio = System.currentTimeMillis();
        System.out.println("biblioteca " + (endTimeBiblio - startTimeBiblio) / 1000 + " segundos");
        /////////////COLECCIONES///////////////////
        long startTimecol = System.currentTimeMillis();
        coleccion = new Coleccion();
        coDao = factory.getColeccionDao(COLECCION);
        colecciones = coDao.listColeccion();
        long endTimecol = System.currentTimeMillis();
        System.out.println("coleccion " + (endTimecol - startTimecol) / 1000 + " segundos");
        /////////////TIPOS/////////////////////////
        long startTimetipo = System.currentTimeMillis();
        tipo = new Tipo();
        tiDao = factory.getTipoDao(TIPO);
        tipos = tiDao.listTipo();
        long endTimetipo = System.currentTimeMillis();
        System.out.println("tipo " + (endTimetipo - startTimetipo) / 1000 + " segundos");
        /////////////ESPACIAL/////////////////////////
        long startTimeespacial = System.currentTimeMillis();
        espacial = new Cobertura();
        esDao = factory.getEspacialDao(ESPACIAL);
        espaciales = esDao.listEspacial();
        long endTimeespacial = System.currentTimeMillis();
        System.out.println("espacial " + (endTimeespacial - startTimeespacial) / 1000 + " segundos");
        ///////////////TEMPORAL///////////////////
        long startTimetemporal = System.currentTimeMillis();
        temporal = new CoberturaTemporal();
        teDao = factory.getTemporalDao(TEMPORAL);
        temporales = teDao.listTemporal();
        long endTimetemporal = System.currentTimeMillis();
        System.out.println("temporal " + (endTimetemporal - startTimetemporal) / 1000 + " segundos");
        ///////////////AUDIENCIA///////////////////
        long startTimeaudiencia = System.currentTimeMillis();
        audiencia = new Audiencia();
        auDao = factory.getAudienciaDao(AUDIENCIA);
        audiencias = auDao.listAudiencia();
        long endTimeaudiencia = System.currentTimeMillis();
        System.out.println("audiencia " + (endTimeaudiencia - startTimeaudiencia) / 1000 + " segundos");
        /////////////MAPAS//////////////////////////
        emptyModel = new DefaultMapModel();

        ///////FILTROS///////////////////////////
    }

    public ArrayList<Novedad> getLstNovedades() {
        return lstNovedades;
    }

    public void setLstNovedades(ArrayList<Novedad> lstNovedades) {
        this.lstNovedades = lstNovedades;
    }

    /////////////////////////////////////////////////////////////
    //////////////METODOS PROPIOS///////////////////////////
    /////////////////////////////////////////////////////////////
    public void filtroMultimedia() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Bvirtual/Catalogo?Busqueda=" + buscador + "&Material=34,35,36,38,39,18,19,20");
    }

    public void filtroDocumental() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Bvirtual/Catalogo?Busqueda=" + buscador + "&Material=3,31,24,30,32,33,6,26,27");
    }

    public void filtroGeneral() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Bvirtual/Catalogo?Busqueda=" + buscador);
    }

    public void cargaFiltros() {
        if (gidmaterial != null) {
            indicador = 1;
            listdocumental = new ArrayList<>();
            String[] ids = gidmaterial.split(",");
            stipo.addAll(Arrays.asList(ids));
            conTipo = new ArrayList<>();
            String consulta = "ID_TIPO IN(" + gidmaterial + ")";
            conTipo.add(consulta);
            RequestContext.getCurrentInstance().execute("disTipo(0)");
        }
        if (gidbiblioteca != null) {
            indicador = 1;
            listdocumental = new ArrayList<>();
            //if (!gidbiblioteca.equals("")) {
            String[] ids = gidbiblioteca.split(",");
            sbiblioteca.addAll(Arrays.asList(ids));
            conBiblioteca = new ArrayList<>();
            String consulta = "ID_BIBLIOTECA_FUENTE IN(" + gidbiblioteca + ")";
            conBiblioteca.add(consulta);
            RequestContext.getCurrentInstance().execute("disBiblioteca(0)");
        }
        if (gidcoleccion != null) {
            indicador = 1;
            listdocumental = new ArrayList<>();
            //if (!gidcoleccion.equals("")) {
            String[] ids = gidcoleccion.split(",");
            scoleccion.addAll(Arrays.asList(ids));
            conColeccion = new ArrayList<>();
            String consulta = "ID_COLECCION IN(" + gidcoleccion + ")";
            conColeccion.add(consulta);
            RequestContext.getCurrentInstance().execute("disColeccion(0)");
        }
        filtraFiltros();
        realizarBusqueda();
        //realizaConsulta();
    }

    public void cambiaOrden() {
        Collections.sort(listdocumental, new Comparator<Documental>() {
            @Override
            public int compare(Documental o1, Documental o2) {
                switch (campoOrder) {
                    case "TITULO":
                        if (ordenOrder.equals("ASC")) {
                            return o1.getTITULO().compareTo(o2.getTITULO());
                        } else if (ordenOrder.equals("DESC")) {
                            return o2.getTITULO().compareTo(o1.getTITULO());
                        }
                    case "TIPO":
                        if (ordenOrder.equals("ASC")) {
                            return o1.getTIPO().compareTo(o2.getTIPO());
                        } else if (ordenOrder.equals("DESC")) {
                            return o2.getTIPO().compareTo(o1.getTIPO());
                        }
                    case "PROVINCIA":
                        if (ordenOrder.equals("ASC")) {
                            return o1.getPROVINCIA().compareTo(o2.getPROVINCIA());
                        } else if (ordenOrder.equals("DESC")) {
                            return o2.getPROVINCIA().compareTo(o1.getPROVINCIA());
                        }
                    default:
                        if (ordenOrder.equals("ASC")) {
                            return o1.getTITULO().compareTo(o2.getTITULO());
                        } else if (ordenOrder.equals("DESC")) {
                            return o2.getTITULO().compareTo(o1.getTITULO());
                        } else {
                            return o1.getTITULO().compareTo(o2.getTITULO());
                        }
                }
            }
        });
        RequestContext.getCurrentInstance().update("formCatalogo:listCatalogo");
        RequestContext.getCurrentInstance().update("formCatalogo:nResultado");
    }

    public void realizaConsulta() {
        lConsulta = new ArrayList<>();
        lConsulta.addAll(conBiblioteca);
        lConsulta.addAll(conColeccion);
        lConsulta.addAll(conTipo);
        lConsulta.addAll(conEspacial);
        lConsulta.addAll(conTemporal);
        lConsulta.addAll(conAudiencia);
        lConsulta.addAll(conBuscador);
        String consultaFinal = "";
        for (int i = 0; i < lConsulta.size(); i++) {
            consultaFinal = consultaFinal + " AND (" + lConsulta.get(i) + ")";
        }
        System.out.println("ESTA ES LA CONSULTA QUE SE ENVIA: " + consultaFinal);
        List<Documental> lconsulta = dDao.buscaDocumental(consultaFinal, indicador);
        listdocumental.addAll(lconsulta);
        if (!listdocumental.isEmpty()) {
            if (listdocumental.size() == 1) {
                selectDocumental(listdocumental.get(0).getID_DOCUMENTAL());
            }
            if (lconsulta.size() < 20) {
                RequestContext.getCurrentInstance().execute("$('#divVerMas').css({display:'none'})");
            } else {
                RequestContext.getCurrentInstance().execute("$('#divVerMas').css({display:'inline-block'})");
            }
            RequestContext.getCurrentInstance().execute("displayListado(1)");
        } else {
            RequestContext.getCurrentInstance().execute("displayListado(0)");
        }
        cambiaOrden();
    }

    public void realizarBusquedaMovil() {
        buscador = buscadorMovil;
        realizarBusqueda();
    }

    public void realizarBusqueda() {
        if (buscador != null) {
            indicador = 1;
            listdocumental = new ArrayList<>();
            conBuscador = new ArrayList<>();
            String buscadorFinal = buscador.replace("[", "[[]");
            String[] lString = buscadorFinal.split(" ");
            String consulta = "";
            for (int i = 0; i < lString.length; i++) {
                if (i > 0) {
                    consulta = consulta + "OR ";
                }
                consulta = consulta + " TITULO COLLATE Latin1_General_CI_AI Like '%" + lString[i] + "%' COLLATE Latin1_General_CI_AI "
                        + " OR TITULO_ALTERNATIVO COLLATE Latin1_General_CI_AI Like '%" + lString[i] + "%' COLLATE Latin1_General_CI_AI "
                        + " OR AUTORES COLLATE Latin1_General_CI_AI Like '%" + lString[i] + "%' COLLATE Latin1_General_CI_AI "
                        + " OR EDITORIAL COLLATE Latin1_General_CI_AI Like '%" + lString[i] + "%' COLLATE Latin1_General_CI_AI "
                        + " OR TEMAS COLLATE Latin1_General_CI_AI Like '%" + lString[i] + "%' COLLATE Latin1_General_CI_AI "
                        //+ " OR VW.TABLA_CONTENIDOS COLLATE Latin1_General_CI_AI Like '%" + lString[i] + "%' COLLATE Latin1_General_CI_AI "
                        + " OR OTRO COLLATE Latin1_General_CI_AI Like '%" + lString[i] + "%' COLLATE Latin1_General_CI_AI "
                        + " OR DESCRIPCION COLLATE Latin1_General_CI_AI Like '%" + lString[i] + "%' COLLATE Latin1_General_CI_AI "
                        + " OR RESUMEN COLLATE Latin1_General_CI_AI Like '%" + lString[i] + "%' COLLATE Latin1_General_CI_AI "
                        + " OR COLECCION COLLATE Latin1_General_CI_AI Like '%" + lString[i] + "%' COLLATE Latin1_General_CI_AI ";
            }

            conBuscador.add(consulta);
        }
        realizaConsulta();
    }

    public void selectDocumental(String idDocumental) {
        documental = dDao.findDocumental(idDocumental);
        Double lat = Double.parseDouble(documental.getLATITUD());
        Double lng = Double.parseDouble(documental.getLONGITUD());
        LatLng coord1 = new LatLng(lat, lng);
        emptyModel.addOverlay(new Marker(coord1, documental.getTITULO_MAPA()));
        lautor = aDao.listarAutorIdDocumental(idDocumental);
        lcontribuidor = cDao.listarContribuidorIdDocumental(idDocumental);
        lcoleccion = coDao.listarColeccionIdDocumental(idDocumental);
        lserie = sDao.listarSerieIdDocumental(idDocumental);
        llenguaje = lDao.listarSerieIdDocumental(idDocumental);
        ltema = tDao.listarSerieIdDocumental(idDocumental);
        RequestContext.getCurrentInstance().update("formCatalogo:detalleDocumental");
        RequestContext.getCurrentInstance().execute("realizaClick('" + idDocumental + "')");
    }

    public void filtraFiltros() {

        String idBiblioteca = "";
        for (int i = 0; i < sbiblioteca.size(); i++) {
            if (!sbiblioteca.get(i).equals("-1")) {
                idBiblioteca = idBiblioteca + sbiblioteca.get(i) + ",";
            }
        }
        if (!idBiblioteca.equals("")) {
            idBiblioteca = idBiblioteca.substring(0, idBiblioteca.length() - 1);
        }

        String idColeccion = "";
        for (int i = 0; i < scoleccion.size(); i++) {
            if (!scoleccion.get(i).equals("-1")) {
                idColeccion = idColeccion + scoleccion.get(i) + ",";
            }
        }
        if (!idColeccion.equals("")) {
            idColeccion = idColeccion.substring(0, idColeccion.length() - 1);
        }

        String idTipo = "";
        for (int i = 0; i < stipo.size(); i++) {
            if (!stipo.get(i).equals("-1")) {
                idTipo = idTipo + stipo.get(i) + ",";
            }
        }
        if (!idTipo.equals("")) {
            idTipo = idTipo.substring(0, idTipo.length() - 1);
        }

        String idEspacial = "";
        for (int i = 0; i < sespacial.size(); i++) {
            if (!sespacial.get(i).equals("-1")) {
                idEspacial = idEspacial + "'" + sespacial.get(i) + "'" + ",";
            }
        }
        if (!idEspacial.equals("")) {
            idEspacial = idEspacial.substring(0, idEspacial.length() - 1);
        }

        String idTemporal = "";
        for (int i = 0; i < stemporal.size(); i++) {
            if (!stemporal.get(i).equals("-1")) {
                idTemporal = idTemporal + stemporal.get(i) + ",";
            }
        }
        if (!idTemporal.equals("")) {
            idTemporal = idTemporal.substring(0, idTemporal.length() - 1);
        }

        String idAudiencia = "";
        for (int i = 0; i < saudiencia.size(); i++) {
            if (!saudiencia.get(i).equals("-1")) {
                idAudiencia = idAudiencia + saudiencia.get(i) + ",";
            }
        }
        if (!idAudiencia.equals("")) {
            idAudiencia = idAudiencia.substring(0, idAudiencia.length() - 1);
        }

        String fBiblioteca = "";
        if (!idBiblioteca.equals("")) {
            fBiblioteca = " AND D.ID_BIBLIOTECA_FUENTE IN (" + idBiblioteca + ")";
        }

        String fColeccion = "";
        if (!idColeccion.equals("")) {
            fColeccion = " AND CD.ID_COLECCION IN (" + idColeccion + ")";
        }

        String fTipo = "";
        if (!idTipo.equals("")) {
            fTipo = " AND D.ID_TIPO IN (" + idTipo + ")";
        }

        String fEspacial = "";
        if (!idEspacial.equals("")) {
            fEspacial = " AND CE.ID_PAIS IN (" + idEspacial + ")";
        }

        String fTemporal = "";
        if (!idTemporal.equals("")) {
            fTemporal = " AND D.ID_COBERTURA_TEMPORAL IN (" + idTemporal + ")";
        }

        String fAudiencia = "";
        if (!idAudiencia.equals("")) {
            fAudiencia = " AND D.ID_AUDIENCIA IN (" + idAudiencia + ")";
        }
        long startTimeBib = System.currentTimeMillis();
        bibliotecas = biDao.filtraBiblioteca(fColeccion + fTipo + fEspacial + fTemporal + fAudiencia);
        long endTimeBib = System.currentTimeMillis();
        System.out.println("Filtro Biblioteca " + (endTimeBib - startTimeBib) / 1000 + " segundos");
        long startTimeCol = System.currentTimeMillis();
        colecciones = coDao.filtraColeccion(fBiblioteca + fTipo + fEspacial + fTemporal + fAudiencia);
        long endTimeCol = System.currentTimeMillis();
        System.out.println("Filtro colecciones " + (endTimeCol - startTimeCol) / 1000 + " segundos");
        long startTimeTip = System.currentTimeMillis();
        tipos = tiDao.filtraTipo(fBiblioteca + fColeccion + fEspacial + fTemporal + fAudiencia);
        long endTimeColTip = System.currentTimeMillis();
        System.out.println("Filtro tipos " + (endTimeColTip - startTimeTip) / 1000 + " segundos");
        long startTimeEspac = System.currentTimeMillis();
        espaciales = esDao.filtraEspacial(fBiblioteca + fColeccion + fTipo + fTemporal + fAudiencia);
        long endTimeColEspac = System.currentTimeMillis();
        System.out.println("Filtro espaciales " + (endTimeColEspac - startTimeEspac) / 1000 + " segundos");
        long startTimeTemp = System.currentTimeMillis();
        temporales = teDao.filtraTemporal(fBiblioteca + fColeccion + fTipo + fEspacial + fAudiencia);
        long endTimeColTemp = System.currentTimeMillis();
        System.out.println("Filtro temporales " + (endTimeColTemp - startTimeTemp) / 1000 + " segundos");
        long startTimeAud = System.currentTimeMillis();
        audiencias = auDao.filtraAudiencia(fBiblioteca + fColeccion + fTipo + fTemporal + fEspacial);
        long endTimeColAud = System.currentTimeMillis();
        System.out.println("Filtro audiencias " + (endTimeColAud - startTimeAud) / 1000 + " segundos");

        RequestContext.getCurrentInstance().update("formCatalogo:cboBiblioteca");
        RequestContext.getCurrentInstance().update("formCatalogo:cboColeccion");
        RequestContext.getCurrentInstance().update("formCatalogo:cboTipo");
        RequestContext.getCurrentInstance().update("formCatalogo:cboEspacial");
        RequestContext.getCurrentInstance().update("formCatalogo:cboTemporal");
        RequestContext.getCurrentInstance().update("formCatalogo:cboAudiencia");
        RequestContext.getCurrentInstance().execute("cargaPagina()");

    }

    public void checkBiblioteca() {
        indicador = 1;
        listdocumental = new ArrayList<>();
        conBiblioteca = new ArrayList<>();
        String idBiblioteca = "";
        int aux = 0;
        for (int i = 0; i < sbiblioteca.size(); i++) {
            aux++;
            idBiblioteca = idBiblioteca + sbiblioteca.get(i) + ",";
        }
        if (aux != 0) {
            RequestContext.getCurrentInstance().execute("disBiblioteca(0)");
            idBiblioteca = idBiblioteca.substring(0, idBiblioteca.length() - 1);
            String consulta = "ID_BIBLIOTECA_FUENTE IN(" + idBiblioteca + ")";
            conBiblioteca.add(consulta);
        } else {
            RequestContext.getCurrentInstance().execute("disBiblioteca(1)");
        }
        filtraFiltros();

        realizaConsulta();
    }

    public void checkColeccion() {
        indicador = 1;
        listdocumental = new ArrayList<>();
        conColeccion = new ArrayList<>();
        String idColeccion = "";
        int aux = 0;
        for (int i = 0; i < scoleccion.size(); i++) {
            aux++;
            idColeccion = idColeccion + scoleccion.get(i) + ",";
        }
        if (aux != 0) {
            RequestContext.getCurrentInstance().execute("disColeccion(0)");
            idColeccion = idColeccion.substring(0, idColeccion.length() - 1);
            String consulta = "ID_COLECCION IN(" + idColeccion + ")";
            conColeccion.add(consulta);
        } else {
            RequestContext.getCurrentInstance().execute("disColeccion(1)");
        }

        filtraFiltros();

        realizaConsulta();
    }

    public void checkTipo() {
        indicador = 1;
        listdocumental = new ArrayList<>();
        conTipo = new ArrayList<>();
        String idTipo = "";
        int aux = 0;
        for (int i = 0; i < stipo.size(); i++) {
            aux++;
            idTipo = idTipo + stipo.get(i) + ",";
        }
        if (aux != 0) {
            RequestContext.getCurrentInstance().execute("disTipo(0)");
            idTipo = idTipo.substring(0, idTipo.length() - 1);
            String consulta = "ID_TIPO IN(" + idTipo + ")";
            conTipo.add(consulta);
        } else {
            RequestContext.getCurrentInstance().execute("disTipo(1)");
        }

        filtraFiltros();
        realizaConsulta();
    }

    public void checkEspacial() {
        indicador = 1;
        listdocumental = new ArrayList<>();
        conEspacial = new ArrayList<>();
        String idEspacial = "";
        int aux = 0;
        for (int i = 0; i < sespacial.size(); i++) {
            aux++;
            idEspacial = idEspacial + "'" + sespacial.get(i) + "'" + ",";
        }
        if (aux != 0) {
            RequestContext.getCurrentInstance().execute("disEspacial(0)");
            idEspacial = idEspacial.substring(0, idEspacial.length() - 1);
            String consulta = "ID_PAIS IN(" + idEspacial + ")";
            conEspacial.add(consulta);
        } else {
            RequestContext.getCurrentInstance().execute("disEspacial(1)");
        }

        filtraFiltros();
        realizaConsulta();
    }

    public void checkTemporal() {
        indicador = 1;
        listdocumental = new ArrayList<>();
        conTemporal = new ArrayList<>();
        String idTemporal = "";
        int aux = 0;
        for (int i = 0; i < stemporal.size(); i++) {
            aux++;
            idTemporal = idTemporal + stemporal.get(i) + ",";
        }
        if (aux != 0) {
            RequestContext.getCurrentInstance().execute("disTemporal(0)");
            idTemporal = idTemporal.substring(0, idTemporal.length() - 1);
            String consulta = "ID_COBERTURA_TEMPORAL IN(" + idTemporal + ")";
            conTipo.add(consulta);
        } else {
            RequestContext.getCurrentInstance().execute("disTemporal(1)");
        }

        filtraFiltros();
        realizaConsulta();
    }

    public void checkAudiencia() {
        indicador = 1;
        listdocumental = new ArrayList<>();
        conAudiencia = new ArrayList<>();
        String idAudiencia = "";
        int aux = 0;
        for (int i = 0; i < saudiencia.size(); i++) {
            aux++;
            idAudiencia = idAudiencia + saudiencia.get(i) + ",";
        }
        if (aux != 0) {
            RequestContext.getCurrentInstance().execute("disAudiencia(0)");
            idAudiencia = idAudiencia.substring(0, idAudiencia.length() - 1);
            String consulta = "ID_AUDIENCIA IN(" + idAudiencia + ")";
            conAudiencia.add(consulta);
        } else {
            RequestContext.getCurrentInstance().execute("disAudiencia(1)");
        }

        filtraFiltros();
        realizaConsulta();
    }

    ////////////QUITAR FILTROS///////////////////////////////////
    public void qBiblioteca() {
        indicador = 1;
        listdocumental = new ArrayList<>();
        conBiblioteca = new ArrayList<>();
        sbiblioteca = new ArrayList<>();
        RequestContext.getCurrentInstance().execute("disBiblioteca(1)");
        filtraFiltros();
        realizaConsulta();
    }

    public void qColeccion() {
        indicador = 1;
        listdocumental = new ArrayList<>();
        conColeccion = new ArrayList<>();
        scoleccion = new ArrayList<>();
        RequestContext.getCurrentInstance().execute("disColeccion(1)");
        filtraFiltros();
        realizaConsulta();
    }

    public void qTipo() {
        indicador = 1;
        listdocumental = new ArrayList<>();
        conTipo = new ArrayList<>();
        stipo = new ArrayList<>();
        RequestContext.getCurrentInstance().execute("disTipo(1)");
        filtraFiltros();
        realizaConsulta();
    }

    public void qEspacial() {
        indicador = 1;
        listdocumental = new ArrayList<>();
        conEspacial = new ArrayList<>();
        sespacial = new ArrayList<>();
        RequestContext.getCurrentInstance().execute("disEspacial(1)");
        filtraFiltros();
        realizaConsulta();
    }

    public void qTemporal() {
        indicador = 1;
        listdocumental = new ArrayList<>();
        conTemporal = new ArrayList<>();
        stemporal = new ArrayList<>();
        RequestContext.getCurrentInstance().execute("disTemporal(1)");
        filtraFiltros();
        realizaConsulta();
    }

    public void qAudiencia() {
        indicador = 1;
        listdocumental = new ArrayList<>();
        conAudiencia = new ArrayList<>();
        saudiencia = new ArrayList<>();
        RequestContext.getCurrentInstance().execute("disAudiencia(1)");
        filtraFiltros();
        realizaConsulta();
    }

    public void cargarMas() {
        indicador = indicador + 1;
        realizaConsulta();
    }

    /////////////////////////////////////////////////////////////
    //////////////OBTENER EL MAPA POR ID DE DOCUMENTAL///////////
    /////////////////////////////////////////////////////////////
    public void buscarMapa() {
        System.out.println("ENTRO PAPU :)");
    }

    public void aumentarVisita() {
        dDao.aumentarVisita(documental.getID_DOCUMENTAL());
    }

    /////////////////////////////////////////////////////////////
    //////////////GETTER Y SETTER///////////////////////////
    /////////////////////////////////////////////////////////////
    public Documental getDocumental() {
        return documental;
    }

    public void setDocumental(Documental documental) {
        this.documental = documental;
    }

    public List<Documental> getListdocumental() {
        RequestContext.getCurrentInstance().execute("cargaNueva()");
        return listdocumental;
    }

    public void setListdocumental(List<Documental> listdocumental) {
        this.listdocumental = listdocumental;
    }

    public List<Autor> getLautor() {
        return lautor;
    }

    public void setLautor(List<Autor> lautor) {
        this.lautor = lautor;
    }

    public List<Contribuidor> getLcontribuidor() {
        return lcontribuidor;
    }

    public void setLcontribuidor(List<Contribuidor> lcontribuidor) {
        this.lcontribuidor = lcontribuidor;
    }

    public List<Coleccion> getLcoleccion() {
        return lcoleccion;
    }

    public void setLcoleccion(List<Coleccion> lcoleccion) {
        this.lcoleccion = lcoleccion;
    }

    public List<Serie> getLserie() {
        return lserie;
    }

    public void setLserie(List<Serie> lserie) {
        this.lserie = lserie;
    }

    public List<Lenguaje> getLlenguaje() {
        return llenguaje;
    }

    public void setLlenguaje(List<Lenguaje> llenguaje) {
        this.llenguaje = llenguaje;
    }

    public List<Tema> getLtema() {
        return ltema;
    }

    public void setLtema(List<Tema> ltema) {
        this.ltema = ltema;
    }

    public String getBuscador() {
        return buscador;
    }

    public void setBuscador(String buscador) {
        this.buscador = buscador;
    }

    public String getBuscadorMovil() {
        return buscadorMovil;
    }

    public void setBuscadorMovil(String buscadorMovil) {
        this.buscadorMovil = buscadorMovil;
    }

    /////////////////////////////////////////////////////////////
    //////////////SELECCIÓN DE FILTROS///////////////////////////
    /////////////////////////////////////////////////////////////
    public List<String> getSbiblioteca() {
        return sbiblioteca;
    }

    public void setSbiblioteca(List<String> sbiblioteca) {
        this.sbiblioteca = sbiblioteca;
    }

    public List<String> getScoleccion() {
        return scoleccion;
    }

    public void setScoleccion(List<String> scoleccion) {
        this.scoleccion = scoleccion;
    }

    public List<String> getStipo() {
        return stipo;
    }

    public void setStipo(List<String> stipo) {
        this.stipo = stipo;
    }

    public List<String> getSespacial() {
        return sespacial;
    }

    public void setSespacial(List<String> sespacial) {
        this.sespacial = sespacial;
    }

    public List<String> getStemporal() {
        return stemporal;
    }

    public void setStemporal(List<String> stemporal) {
        this.stemporal = stemporal;
    }

    public List<String> getSaudiencia() {
        return saudiencia;
    }

    public void setSaudiencia(List<String> saudiencia) {
        this.saudiencia = saudiencia;
    }

    ////////////////////////////////////////
    ///////////////BIBLIOTECA///////////////
    ////////////////////////////////////////
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    ////////////////////////////////////////
    ///////////////COLECCIONES///////////////
    ////////////////////////////////////////
    public Coleccion getColeccion() {
        return coleccion;
    }

    public void setColeccion(Coleccion coleccion) {
        this.coleccion = coleccion;
    }

    public List<Coleccion> getColecciones() {
        return colecciones;
    }

    public void setColecciones(List<Coleccion> colecciones) {
        this.colecciones = colecciones;
    }

    ////////////////////////////////////////
    ////////////////////TIPOS///////////////
    ////////////////////////////////////////
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    ////////////////////////////////////////
    ///////////////ESPACIAL///////////////
    ////////////////////////////////////////
    public Cobertura getEspacial() {
        return espacial;
    }

    public void setEspacial(Cobertura espacial) {
        this.espacial = espacial;
    }

    public List<Cobertura> getEspaciales() {
        return espaciales;
    }

    public void setEspaciales(List<Cobertura> espaciales) {
        this.espaciales = espaciales;
    }

    ////////////////////////////////////////
    ///////////////TEMPORAL///////////////
    ////////////////////////////////////////
    public CoberturaTemporal getTemporal() {
        return temporal;
    }

    public void setTemporal(CoberturaTemporal temporal) {
        this.temporal = temporal;
    }

    public List<CoberturaTemporal> getTemporales() {
        return temporales;
    }

    public void setTemporales(List<CoberturaTemporal> temporales) {
        this.temporales = temporales;
    }

    ////////////////////////////////////////
    ///////////////AUDIENCIA///////////////
    ////////////////////////////////////////
    public Audiencia getAudiencia() {
        return audiencia;
    }

    public void setAudiencia(Audiencia audiencia) {
        this.audiencia = audiencia;
    }

    public List<Audiencia> getAudiencias() {
        return audiencias;
    }

    public void setAudiencias(List<Audiencia> audiencias) {
        this.audiencias = audiencias;
    }

    ////////////////////////////////////////
    ///////////////MAPAS///////////////
    ////////////////////////////////////////
    public MapModel getEmptyModel() {
        return emptyModel;
    }

    public void setEmptyModel(MapModel emptyModel) {
        this.emptyModel = emptyModel;
    }

    ////////////////////////////////////////
    ///////////////ORDER BY///////////////
    ////////////////////////////////////////
    public String getCampoOrder() {
        return campoOrder;
    }

    public void setCampoOrder(String campoOrder) {
        this.campoOrder = campoOrder;
    }

    public String getOrdenOrder() {
        return ordenOrder;
    }

    public void setOrdenOrder(String ordenOrder) {
        this.ordenOrder = ordenOrder;
    }

    //TRAER FILTROS DESDE OTRAS PAGINAS
    public String getGidmaterial() {
        return gidmaterial;
    }

    public void setGidmaterial(String gidmaterial) {
        this.gidmaterial = gidmaterial;
    }

    public String getGidbiblioteca() {
        return gidbiblioteca;
    }

    public void setGidbiblioteca(String gidbiblioteca) {
        this.gidbiblioteca = gidbiblioteca;
    }

    public String getGidcoleccion() {
        return gidcoleccion;
    }

    public void setGidcoleccion(String gidcoleccion) {
        this.gidcoleccion = gidcoleccion;
    }

    public String getID_DOCUMENTAL() {
        return ID_DOCUMENTAL;
    }

    public void setID_DOCUMENTAL(String ID_DOCUMENTAL) {
        this.ID_DOCUMENTAL = ID_DOCUMENTAL;
    }

}
