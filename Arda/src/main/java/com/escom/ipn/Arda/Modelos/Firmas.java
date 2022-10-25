/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author DEZKS
 */
@Document("Firmas")
public class Firmas {
    
    @Id
    private String id;
    
    private String firma;
    private Boolean reclamada;
    private String terrario_id;

    public Firmas(String firma, Boolean validado, String terrario_id) {
        this.firma = firma;
        this.reclamada = validado;
        this.terrario_id = terrario_id;
    }

    public Firmas() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public Boolean getReclamada() {
        return reclamada;
    }

    public void setReclamada(Boolean reclamada) {
        this.reclamada = reclamada;
    }


    public String getTerrario_id() {
        return terrario_id;
    }

    public void setTerrario_id(String terrario_id) {
        this.terrario_id = terrario_id;
    }
    
    
}
