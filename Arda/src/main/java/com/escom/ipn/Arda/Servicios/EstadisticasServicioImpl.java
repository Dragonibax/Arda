/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Estadisticas;
import com.escom.ipn.Arda.Repositorios.IEstadisticasRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEZKS
 */
@Service
public class EstadisticasServicioImpl implements IEstadisticasServicio{
    
    @Autowired
    private IEstadisticasRepositorio repositorio;
    
    @Override
    public List<Estadisticas> obtenerEstadisticas() {
        return repositorio.findAll();
    }

    @Override
    public Estadisticas obtenerEstadisticaEspecifica(String id) {
        Optional<Estadisticas> result = repositorio.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
        }
        return null;
    }

    @Override
    public Estadisticas registraEstadistica(Estadisticas recoleccion) {
        return repositorio.insert(recoleccion);
    }
    
}
