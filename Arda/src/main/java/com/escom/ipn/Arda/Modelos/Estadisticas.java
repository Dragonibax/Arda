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
    private String id;
    
    private String Humedad;
    private String Iluminacion;
    private String Hora;
    private String Temperatura;

    public Estadisticas() {
    }

    public Estadisticas(String id, String Humedad, String Iluminacion, String Hora, String Temperatura) {
        this.id = id;
        this.Humedad = Humedad;
        this.Iluminacion = Iluminacion;
        this.Hora = Hora;
        this.Temperatura = Temperatura;
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

    public String getIluminacion() {
        return Iluminacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
