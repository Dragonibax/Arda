/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Controladores.Privados;

import com.escom.ipn.Arda.DTO.EstadisticasDTO;
import com.escom.ipn.Arda.Modelos.Estadisticas;
import com.escom.ipn.Arda.Modelos.JsonResponse;
import com.escom.ipn.Arda.Modelos.Terrarios;
import com.escom.ipn.Arda.Repositorios.IUsuariosRepositorio;
import com.escom.ipn.Arda.Servicios.EmailsServicio;
import com.escom.ipn.Arda.Servicios.IEstadisticasServicio;
import com.escom.ipn.Arda.Servicios.ITokensServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEZKS
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
@RequestMapping("/api/private")
public class EstadisticasControlador {

    @Autowired
    private EmailsServicio emailService;
    @Autowired
    private IEstadisticasServicio servicioEstadisticas;
    @Autowired
    private ITokensServicio servicioTokens;
    
    /*Retorna un historial de estadisticas*/
    @GetMapping("/estadisticas/{Terrario_id}")
    public ResponseEntity<JsonResponse> getEstadisticas(@PathVariable String Terrario_id){
        List<Estadisticas> estadisticas = servicioEstadisticas.obtenerEstadisticas(Terrario_id);
        return new ResponseEntity<>(new JsonResponse(estadisticas, "¡Exito!"),HttpStatus.OK);
    }
    
    /*Retorna la Ultima estadistica registrada*/
    @GetMapping("/estadisticas/{Terrario_ID}/{id}")
    public ResponseEntity<JsonResponse> getEstadistica(@PathVariable String Terrario_ID, @PathVariable String id){
        Estadisticas ultimaEstadistica = servicioEstadisticas.obtenerEstadisticaEspecifica(id);
        return new ResponseEntity<>(new JsonResponse(ultimaEstadistica, "Ultima estadistica"),HttpStatus.OK);
    }
    
    /*agrega una nueva estadistica al historial*/
    @PostMapping("/estadisticas")
    public ResponseEntity<JsonResponse> postEstadistica(@RequestBody EstadisticasDTO stats, @RequestHeader("Authorization") String token){
        Terrarios terrario = servicioTokens.getTerrarioFromToken(token);
        servicioEstadisticas.registraEstadistica(stats, terrario);
        emailService.sendAlert(stats.getTipo_alerta(),terrario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
