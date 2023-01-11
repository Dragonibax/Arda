/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.DTO.EstadisticasDTO;
import com.escom.ipn.Arda.Modelos.Estadisticas;
import com.escom.ipn.Arda.Modelos.Terrarios;
import java.util.List;

/**
 *
 * @author OnixR
 */
public interface IEstadisticasServicio {
    public List<Estadisticas> obtenerEstadisticas(String terrario_id);
    public Estadisticas obtenerEstadisticaEspecifica(String id);
    public Estadisticas registraEstadistica(EstadisticasDTO recoleccion, Terrarios terrario);
}
