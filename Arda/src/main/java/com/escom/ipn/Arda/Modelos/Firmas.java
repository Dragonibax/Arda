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

/**
 *
 * @author DEZKS
 */
@Document("Firmas")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Firmas {
    
    @Id
    private String id;
    
    private String firma;
    private Boolean reclamada;
    private String terrario_id;

}
