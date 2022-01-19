/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Estadisticas;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEZKS
 */
public interface IEstadisticasServicio {
    public List<Estadisticas> obtenerEstadisticas();
    public Estadisticas obtenerEstadisticaEspecifica(String id);
    public Estadisticas registraEstadistica(Estadisticas recoleccion);
}
