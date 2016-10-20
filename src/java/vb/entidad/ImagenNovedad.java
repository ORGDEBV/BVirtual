
package vb.entidad;


public class ImagenNovedad {
    
   private Integer ID_IOMAGEN_NOVEDAD;

   private String ID_NOVEDAD;

   private String URL_NOVEDAD;
   private String ORDEN;

    public ImagenNovedad() {
    }

    public Integer getID_IOMAGEN_NOVEDAD() {
        return ID_IOMAGEN_NOVEDAD;
    }

    public void setID_IOMAGEN_NOVEDAD(Integer ID_IOMAGEN_NOVEDAD) {
        this.ID_IOMAGEN_NOVEDAD = ID_IOMAGEN_NOVEDAD;
    }


    public String getID_NOVEDAD() {
        return ID_NOVEDAD;
    }

    public void setID_NOVEDAD(String ID_NOVEDAD) {

        this.ID_NOVEDAD = ID_NOVEDAD;
    }

    public String getURL_NOVEDAD() {
        return URL_NOVEDAD;
    }

    public void setURL_NOVEDAD(String URL_NOVEDAD) {
        this.URL_NOVEDAD = URL_NOVEDAD;
    }

    public String getORDEN() {
        return ORDEN;
    }

    public void setORDEN(String ORDEN) {
        this.ORDEN = ORDEN;
    }
    
    
}
