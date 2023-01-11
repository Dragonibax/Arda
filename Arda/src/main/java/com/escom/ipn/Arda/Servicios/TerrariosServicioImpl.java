/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Terrarios;
import com.escom.ipn.Arda.Modelos.Usuarios;
import com.escom.ipn.Arda.Repositorios.ITerrariosRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author OnixR
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

    @Override
    public List<Terrarios> terrariosDeUsuarios(String id) {
        return repositorio.findByUsuarios_id(id);
    }

    @Override
    public Boolean tieneTerrarios(String id) {
        return !repositorio.findByUsuarios_id(id).isEmpty();
    }

    @Override
    public Terrarios actualizarTerrario(Terrarios actualizado) {
        return repositorio.save(actualizado);
    }
    

    @Override
    public Boolean EliminarTerrario(String id) {
        Optional<Terrarios> terrarioss = repositorio.findById(id);
        if(terrarioss.isPresent()){
            repositorio.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
    
    

    @Override
    public Terrarios obtenerTerrarioporID(String id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Terrarios obtenerTerrarioporMac(String mac) {
        return repositorio.findByMac(mac);
    }
    
}
