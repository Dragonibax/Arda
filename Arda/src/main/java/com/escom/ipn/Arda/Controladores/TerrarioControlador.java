/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Controladores;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEZKS
 */
@RestController
@RequestMapping("/api/private")
public class TerrarioControlador {
    
    @PostMapping("/terrarios")
    public void postTerrario(){
        
    }
    
    @GetMapping("/terrarios/{User_ID}")
    public void getTerrarios(){
        
    }
    
    @GetMapping("/terrarios/{User_ID}/{Terrario_ID}")
    public void getTerrario(){
        
    }
    
    @DeleteMapping("/terrarios")
    public void deleteTerrario(){
        
    }
    
    @PatchMapping("/terrarios")
    public void patchTerrario(){
        
    }
}
