package vb.entidad;

import java.util.Date;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class Comentario {
    
    private int ID_COMENTARIO;
    private String NOMBRE;
    private String CORREO_ELECTRONICO;
    private String COMENTARIO;
    private Date FECHA;

    public int getID_COMENTARIO() {
        return ID_COMENTARIO;
    }

    public void setID_COMENTARIO(int ID_COMENTARIO) {
        this.ID_COMENTARIO = ID_COMENTARIO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getCORREO_ELECTRONICO() {
        return CORREO_ELECTRONICO;
    }

    public void setCORREO_ELECTRONICO(String CORREO_ELECTRONICO) {
        this.CORREO_ELECTRONICO = CORREO_ELECTRONICO;
    }

    public String getCOMENTARIO() {
        return COMENTARIO;
    }

    public void setCOMENTARIO(String COMENTARIO) {
        this.COMENTARIO = COMENTARIO;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date FECHA) {
        this.FECHA = FECHA;
    }
    
}
