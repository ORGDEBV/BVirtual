/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.dao;

import java.util.ArrayList;
import vb.entidad.ImagenNovedad;
import vb.entidad.Novedad;

/**
 *
 * @author virtual
 */
public interface NovedadDao {
    
    ArrayList<Novedad> lisNovedad();
    ArrayList<ImagenNovedad> listImagenesSliderDetalle(String idNovedad);
    ArrayList<Novedad> lisNovedad_vistaGeneral();
    ArrayList<Novedad> lisNovedadUltimas();
    ArrayList<Novedad> lisNovedadUltimas_Inicio();
    Novedad Novedad_vistaDetalle(String idNovedad);
    
}
