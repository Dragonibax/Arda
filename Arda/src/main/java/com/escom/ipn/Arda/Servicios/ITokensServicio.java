/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Terrarios;
import com.escom.ipn.Arda.Modelos.Usuarios;

/**
 *
 * @author DEZKS
 */
public interface ITokensServicio {
    
    public String crearTokenUsuario(Usuarios User);
    public String crearTokenTerrario(Terrarios terrario);
    public Boolean validaToken(String JWT);
    public Usuarios getUserFromToken(String JWT);
    public Terrarios getTerrarioFromToken(String JWT);
}
