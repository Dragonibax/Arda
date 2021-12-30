/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Usuarios;
import com.escom.ipn.Arda.Repositorios.IUsuariosRepositorio;
import com.escom.ipn.Arda.Servicios.Seguridad.IEncriptacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEZKS
 */
@Service
public class UsuariosServicioImpl implements IUsuariosServicio{

    @Autowired
    private IUsuariosRepositorio repositorio;
    
    @Autowired
    private IEncriptacionServicio encriptador;
    
    @Override
    public void crearUsuario(Usuarios User) {
       User.setContraseña(encriptador.Encriptar(User.getContraseña()));
       repositorio.save(User);
    }

    @Override
    public Boolean existe(String correo) {
        return repositorio.findByCorreo(correo)!=null;
    }

    @Override
    public Boolean verificaContraseña(Usuarios User) {
        User.setContraseña(encriptador.Encriptar(User.getContraseña()));
        return repositorio.findByCorreo(User.getCorreo()).getContraseña().equals(User.getContraseña());
    }
    
}
