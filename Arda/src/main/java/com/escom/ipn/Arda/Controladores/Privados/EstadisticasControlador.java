/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Controladores.Privados;

import com.escom.ipn.Arda.Modelos.Estadisticas;
import com.escom.ipn.Arda.Modelos.JsonResponse;
import com.escom.ipn.Arda.Servicios.IEstadisticasServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEZKS
 */
@RestController
@RequestMapping("/api/private")
public class EstadisticasControlador {
    @Autowired
    private IEstadisticasServicio servicioEstadisticas;
    
    /*Retorna un historial de estadisticas*/
    @GetMapping("/estadisticas")
    public ResponseEntity<JsonResponse> getEstadisticas(){
        List<Estadisticas> estadisticas = servicioEstadisticas.obtenerEstadisticas();
        return new ResponseEntity<>(new JsonResponse(estadisticas, "¡Exito!"),HttpStatus.OK);
    }
    
    /*Retorna la Ultima estadistica registrada*/
    @GetMapping("/estadisticas/{Terrario_ID}/{id}")
    public ResponseEntity<Estadisticas> getEstadistica(@PathVariable String Terrario_ID, @PathVariable String id){
        Estadisticas ultimaEstadistica = servicioEstadisticas.obtenerEstadisticaEspecifica(id);
        return new ResponseEntity<>(ultimaEstadistica,HttpStatus.OK);
    }
    
    /*agrega una nueva estadistica al historial*/
    @PostMapping("/estadisticas")
    public ResponseEntity<Estadisticas> postEstadistica(@RequestBody Estadisticas stats){
        return new ResponseEntity<>(servicioEstadisticas.registraEstadistica(stats), HttpStatus.CREATED);
    }
}
