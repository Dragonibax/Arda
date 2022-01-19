/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Lagartijas;
import java.util.List;

/**
 *
 * @author DEZKS
 */
public interface ILagartijasServicio {
    public Lagartijas guardarLagartija(Lagartijas iguana);
    public Boolean existeEnElTerrario(Lagartijas lagartija);
    public Lagartijas actualizarDatos(Lagartijas iguana);
    public Lagartijas buscar(String iguanaID);
    public List<Lagartijas> buscarporterrario(String TerrarioID);
}
