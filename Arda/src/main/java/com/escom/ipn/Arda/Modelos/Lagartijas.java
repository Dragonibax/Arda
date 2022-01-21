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
@Document("Lagartijas")
public class Lagartijas {
    @Id
    private String id;
    private String nombre;
    private Integer edad;
    private Character genero;
    private String color;
    private String terrario_id;
    
    public Lagartijas(){
        
    }
    
    public Lagartijas(String id, String nombre, Integer edad, Character genero, String color, String terrario_id) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.color = color;
        this.terrario_id = terrario_id;
    }

    public Lagartijas(String nombre, Integer edad, Character genero, String color, String terrario_id) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.color = color;
        this.terrario_id = terrario_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTerrario_id() {
        return terrario_id;
    }

    public void setTerrario_id(String terrario_id) {
        this.terrario_id = terrario_id;
    }
    
    
}
