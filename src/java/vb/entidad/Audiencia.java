/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vb.entidad;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class Audiencia {
    
    private int ID_AUDIENCIA;
    private String AUDIENCIA;
    private int CONTEO;

    public int getID_AUDIENCIA() {
        return ID_AUDIENCIA;
    }

    public void setID_AUDIENCIA(int ID_AUDIENCIA) {
        this.ID_AUDIENCIA = ID_AUDIENCIA;
    }

    public String getAUDIENCIA() {
        return AUDIENCIA;
    }

    public void setAUDIENCIA(String AUDIENCIA) {
        this.AUDIENCIA = AUDIENCIA;
    }

    public int getCONTEO() {
        return CONTEO;
    }

    public void setCONTEO(int CONTEO) {
        this.CONTEO = CONTEO;
    }
    
}
