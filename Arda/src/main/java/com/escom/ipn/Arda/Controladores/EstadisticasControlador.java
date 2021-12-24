/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Controladores;

import com.escom.ipn.Arda.Modelos.Estadisticas;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List> getEstadisticas(){
        List<Estadisticas> estadisticas =new ArrayList();
        Estadisticas STAT = new Estadisticas();
        STAT.setTemperatura("CAlido");
        STAT.setHora("10pm");
        STAT.setIluminacion("40");
        estadisticas.add(STAT);
        STAT.setCalefaccion("Activa");
        estadisticas.add(STAT);
        return new ResponseEntity<>(estadisticas,HttpStatus.OK);
    }
    
    /*Retorna la Ultima estadistica registrada*/
    @GetMapping("/estadistica")
    public ResponseEntity<Estadisticas> getEstadistica(){
        Estadisticas ultimaEstadistica = new Estadisticas();
        ultimaEstadistica.setCalefaccion("Media");
        ultimaEstadistica.setHora("12 PM");
        ultimaEstadistica.setHumedad("seco");
        ultimaEstadistica.setIluminacion("10 lumens");
        return new ResponseEntity<>(ultimaEstadistica,HttpStatus.OK);
    }
    
    /*agrega una nueva estadistica al historial*/
    @PostMapping("/estadistica")
    public ResponseEntity<Estadisticas> postEstadistica(@RequestBody Estadisticas stats){
        return new ResponseEntity<>(stats, HttpStatus.CREATED);
    }
}
