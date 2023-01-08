/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author Drago
 */
@Document("Estadisticas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estadisticas {
    
    @Id
    private String id;
    private String terrario_id;
    private String humedad;
    private String hora;
    private String temperatura;
    private String tipo_alerta;    
}
