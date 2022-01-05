/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Firmas;

/**
 *
 * @author DEZKS
 */
public interface IFirmasServicio {
    public Firmas guardarFirma(String terrario_id, String firma);
    public Boolean firmaValida(String terrario_id);
    public Firmas obtenerFirma(String terrario_id);
}
