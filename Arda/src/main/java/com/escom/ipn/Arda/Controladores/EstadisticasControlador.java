/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Controladores;

import com.escom.ipn.Arda.Modelos.Estadisticas;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEZKS
 */
@RestController
@RequestMapping("/api")
public class EstadisticasControlador {
    /*Retorna un historial de estadisticas*/
    @GetMapping("/estadisticas")
    public List getEstadisticas(){
        List estadisticas =new ArrayList();
        estadisticas.add("Temperatura");
        estadisticas.add("Humedad");
        return estadisticas;
    }
    
    /*Retorna la Ultima estadistica registrada*/
    @GetMapping("/estadistica")
    public Estadisticas getEstadistica(){
        Estadisticas ultimaEstadistica = new Estadisticas();
        ultimaEstadistica.setCalefaccion("Media");
        ultimaEstadistica.setHora("12 PM");
        ultimaEstadistica.setHumedad("seco");
        ultimaEstadistica.setIluminacion("10 lumens");
        return ultimaEstadistica;
    }
    
    /*agrega una nueva estadistica al historial*/
    @PostMapping("/estadistica")
    public void postEstadistica(){
        
    }
}