/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Usuarios;

/**
 *
 * @author DEZKS
 */
public interface IUsuariosServicio {
    public void crearUsuario(Usuarios User);
    public Boolean existe(String correo);
    public Boolean verificaContraseña(Usuarios User);
}
