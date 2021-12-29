/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Controladores;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEZKS
 */
@RestController
@RequestMapping("/api/private")
public class LagartijaControlador {
    
    @PostMapping("/lagartijas")
    public void postLagartija(){
        
    }
    
    @DeleteMapping("/lagartijas")
    public void deleteLagartija(){
        
    }
    
    @GetMapping("/lagartijas/{Terrario_ID}")
    public void getLagartijas(@PathVariable String Terrario_ID){
        
    }
    
    @GetMapping("/lagartijas/{Terrario_ID}/{Lagartija_ID}")
    public void getLagartija(){
        
    }
    
    @PatchMapping("/lagartijas")
    public void patchLagartija(){
        
    }
}
