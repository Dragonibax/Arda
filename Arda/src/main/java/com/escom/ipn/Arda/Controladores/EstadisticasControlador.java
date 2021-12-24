/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Controladores;

import com.escom.ipn.Arda.Modelos.Estadisticas;
import com.escom.ipn.Arda.Servicios.IEstadisticasServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private IEstadisticasServicio servicioEstadisticas;
    
    /*Retorna un historial de estadisticas*/
    @GetMapping("/estadisticas")
    public ResponseEntity<List> getEstadisticas(){
        List<Estadisticas> estadisticas = servicioEstadisticas.obtenerEstadisticas();
        return new ResponseEntity<>(estadisticas,HttpStatus.OK);
    }
    
    /*Retorna la Ultima estadistica registrada*/
    @GetMapping("/estadistica")
    public ResponseEntity<Estadisticas> getEstadistica(){
        Estadisticas ultimaEstadistica = servicioEstadisticas.obtenerUltimaEstadistica();
        return new ResponseEntity<>(ultimaEstadistica,HttpStatus.OK);
    }
    
    /*agrega una nueva estadistica al historial*/
    @PostMapping("/estadistica")
    public ResponseEntity<Estadisticas> postEstadistica(@RequestBody Estadisticas stats){
        return new ResponseEntity<>(servicioEstadisticas.registraEstadistica(stats), HttpStatus.CREATED);
    }
}
