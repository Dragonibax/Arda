/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author DEZKS
 */
@Document("Estadisticas")
public class Estadisticas {
    
    @Id
    private String id;
    private String TerrariosID;
    
    private String humedad;
    private String iluminacion;
    private String hora;
    private String temperatura;

    public Estadisticas() {
    }

    public Estadisticas(String id, String Humedad, String Iluminacion, String Hora, String Temperatura) {
        this.id = id;
        this.humedad = Humedad;
        this.iluminacion = Iluminacion;
        this.hora = Hora;
        this.temperatura = Temperatura;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTerrariosID() {
        return TerrariosID;
    }

    public void setTerrariosID(String TerrariosID) {
        this.TerrariosID = TerrariosID;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getIluminacion() {
        return iluminacion;
    }

    public void setIluminacion(String iluminacion) {
        this.iluminacion = iluminacion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
    
}
