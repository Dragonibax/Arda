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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author OnixR
 */
@Service
public class UsuariosServicioImpl implements IUsuariosServicio{

    @Autowired
    private IUsuariosRepositorio repositorio;
    
    @Autowired
    private IEncriptacionServicio encriptador;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void crearUsuario(Usuarios User) {
       User.setContraseña(passwordEncoder.encode(User.getContraseña()));
       repositorio.save(User);
    }

    @Override
    public Boolean existe(String correo) {
        return repositorio.findByCorreo(correo)!=null;
    }

    @Override
    public Boolean verificaContraseña(Usuarios User) {
        Usuarios db = repositorio.findByCorreo(User.getCorreo());
        return passwordEncoder.matches(User.getContraseña(), db.getContraseña());
    }

    @Override
    public Usuarios obtenerDatos(String correo) {
        return repositorio.findByCorreo(correo);
    }
    
}
