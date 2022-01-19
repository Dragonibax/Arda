/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Controladores.Privados;

import com.escom.ipn.Arda.Modelos.JsonResponse;
import com.escom.ipn.Arda.Modelos.Lagartijas;
import com.escom.ipn.Arda.Servicios.ILagartijasServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
public class LagartijaControlador {
    
    @Autowired
    private ILagartijasServicio servicioLagartijas;
    
    @PostMapping("/lagartijas")
    public ResponseEntity<JsonResponse> postLagartija(@RequestBody Lagartijas iguana){
        if(servicioLagartijas.existeEnElTerrario(iguana)){
            return new ResponseEntity(new JsonResponse("La lagartija ya esta registrada en este terrario"),HttpStatus.CONFLICT);
        }else{
            Lagartijas result = servicioLagartijas.guardarLagartija(iguana);
            return new ResponseEntity(new JsonResponse(result,"OK"),HttpStatus.CREATED);
        }        
    }
    
    @DeleteMapping("/lagartijas")
    public void deleteLagartija(){
        
    }
    
    @GetMapping("/lagartijas/{Terrario_ID}")
    public ResponseEntity<JsonResponse> getLagartijas(@PathVariable String Terrario_ID){
        List<Lagartijas> lagartijas=servicioLagartijas.buscarporterrario(Terrario_ID);
        if(lagartijas.isEmpty()){
            return new ResponseEntity(new JsonResponse("No hay lagartijas en este terrario"), HttpStatus.CONFLICT);
        }else{
            return new ResponseEntity(new JsonResponse(lagartijas, "Lista de iguanas"), HttpStatus.ACCEPTED);
        }
    }
    
    @GetMapping("/lagartijas/{Terrario_ID}/{Lagartija_ID}")
    public void getLagartija(){
        
    }
    
    @PatchMapping("/lagartijas")
    public ResponseEntity<JsonResponse> patchLagartija(@RequestBody Lagartijas iguana){
        Lagartijas result = servicioLagartijas.actualizarDatos(iguana);
        return new ResponseEntity(new JsonResponse(result, "OK"), HttpStatus.CREATED);
    }
}
