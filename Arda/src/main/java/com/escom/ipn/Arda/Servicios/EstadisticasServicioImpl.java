/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Estadisticas;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEZKS
 */
@Service
public class EstadisticasServicioImpl implements IEstadisticasServicio{
    
    @Override
    public List<Estadisticas> obtenerEstadisticas() {
        List<Estadisticas> estadisticas =new ArrayList();
        Estadisticas STAT = new Estadisticas();
        STAT.setTemperatura("CAlido");
        STAT.setHora("10pm");
        STAT.setIluminacion("40");
        estadisticas.add(STAT);
        STAT.setCalefaccion("Activa");
        estadisticas.add(STAT);
        return estadisticas;
    }

    @Override
    public Estadisticas obtenerUltimaEstadistica() {
        Estadisticas ultimaEstadistica = new Estadisticas();
        ultimaEstadistica.setCalefaccion("Media");
        ultimaEstadistica.setHora("12 PM");
        ultimaEstadistica.setHumedad("seco");
        ultimaEstadistica.setIluminacion("10 lumens");
        return ultimaEstadistica;
    }

    @Override
    public Estadisticas registraEstadistica(Estadisticas recoleccion) {
        return recoleccion;
    }
    
}
