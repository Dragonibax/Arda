/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Modelos;

import org.springframework.data.annotation.Id;

/**
 *
 * @author DEZKS
 */
public class Usuarios {

    @Id
    private String id;
    
    private String Correo;
    private String Contraseña;
    private String Nombre;
    
    public Usuarios() {
    }

    public Usuarios(String id, String Correo, String Contraseña, String Nombre) {
        this.id = id;
        this.Correo = Correo;
        this.Contraseña = Contraseña;
        this.Nombre = Nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
}
