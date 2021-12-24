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
@Document("Estadisticas")
public class Estadisticas {
    
    @Id
    private String Id;
    
    private String Humedad;
    private String Calefaccion;
    private String Iluminacion;
    private String Hora;
    private String Temperatura;

    public Estadisticas() {
    }
    
    public String getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(String Temperatura) {
        this.Temperatura = Temperatura;
    }

    

    public String getHumedad() {
        return Humedad;
    }

    public void setHumedad(String Humedad) {
        this.Humedad = Humedad;
    }

    public String getCalefaccion() {
        return Calefaccion;
    }

    public void setCalefaccion(String Calefaccion) {
        this.Calefaccion = Calefaccion;
    }

    public String getIluminacion() {
        return Iluminacion;
    }

    public void setIluminacion(String Iluminacion) {
        this.Iluminacion = Iluminacion;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }
    
    
}
