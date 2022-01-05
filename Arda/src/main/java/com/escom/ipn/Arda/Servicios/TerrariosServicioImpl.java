/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Terrarios;
import com.escom.ipn.Arda.Modelos.Usuarios;
import com.escom.ipn.Arda.Repositorios.ITerrariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEZKS
 */
@Service
public class TerrariosServicioImpl implements ITerrariosServicio {
    
    @Autowired
    private ITerrariosRepositorio repositorio;
    
    @Override
    public Terrarios registrarTerrario(Terrarios nuevo, Usuarios propietario) {
        nuevo.setUsuarios_id(propietario.getId());
        return repositorio.insert(nuevo);
    }

    @Override
    public Boolean terrarioExistente(Terrarios nuevo) {
        return repositorio.findByMac(nuevo.getMac())!=null;
    }
    
}
