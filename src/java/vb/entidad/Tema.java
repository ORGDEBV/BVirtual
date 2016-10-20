package vb.entidad;

/**
 *
 * @author Renato Vásquez Tejada - renatovt11@gmail.com
 */
public class Tema {
    
    private int ID_TEMA;
    private String TEMA;
    // varible auxiliar
    String ID_DOCUMENTAL;

    public String getID_DOCUMENTAL() {
        return ID_DOCUMENTAL;
    }

    public void setID_DOCUMENTAL(String ID_DOCUMENTAL) {
        this.ID_DOCUMENTAL = ID_DOCUMENTAL;
    }

    public int getID_TEMA() {
        return ID_TEMA;
    }

    public void setID_TEMA(int ID_TEMA) {
        this.ID_TEMA = ID_TEMA;
    }

    public String getTEMA() {
        return TEMA;
    }

    public void setTEMA(String TEMA) {
        this.TEMA = TEMA;
    }
}
