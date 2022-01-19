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
@Document("Terrarios")
public class Terrarios {
    @Id
    private String id;
    
    private String ubicacion;
    private String altura;
    private String iluminacion_tipo;
    private String usuarios_id;
    private String mac;

    public Terrarios() {
    }

    public Terrarios(String id, String ubicacion, String altura, String iluminacion_tipo, String usuarios_id) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.altura = altura;
        this.iluminacion_tipo = iluminacion_tipo;
        this.usuarios_id = usuarios_id;
    }

    public Terrarios(String ubicacion, String altura, String iluminacion_tipo, String usuarios_id) {
        this.ubicacion = ubicacion;
        this.altura = altura;
        this.iluminacion_tipo = iluminacion_tipo;
        this.usuarios_id = usuarios_id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getIluminacion_tipo() {
        return iluminacion_tipo;
    }

    public void setIluminacion_tipo(String iluminacion_tipo) {
        this.iluminacion_tipo = iluminacion_tipo;
    }

    public String getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(String usuarios_id) {
        this.usuarios_id = usuarios_id;
    }
    
}
