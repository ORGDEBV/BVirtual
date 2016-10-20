/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.bean;

import bv.dao.ComentarioDao;
import bv.dao.impl.DaoFactory;
import static bv.util.Constantes.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import vb.entidad.Comentario;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
@ManagedBean
@RequestScoped
public class comentarioBean {

    private Comentario comentario;
    private final ComentarioDao coDao;

    public comentarioBean() {
        comentario = new Comentario();
        DaoFactory factory = DaoFactory.getInstance();
        coDao = factory.getComentarioDao(COMENTARIO);
    }

    public void creaComentario() {
        int n = coDao.crearEntidad(comentario);
        FacesContext context = FacesContext.getCurrentInstance();
        if (n == 1) {
            comentario = new Comentario();
            RequestContext.getCurrentInstance().execute("PF('dlgComentario').hide()");
            RequestContext.getCurrentInstance().update("formComentario");
            context.addMessage("gMensaje", new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Su comentario fue enviado, gracias."));
        } else {
            context.addMessage("gMensaje", new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Ocurrió un error al enviar su comentario, vuelva a intentarlo"));
        }
        RequestContext.getCurrentInstance().update("gMensaje");
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
}
