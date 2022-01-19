/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Estadisticas;
import com.escom.ipn.Arda.Modelos.Terrarios;
import com.escom.ipn.Arda.Repositorios.IEstadisticasRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEZKS
 */
@Service
public class EstadisticasServicioImpl implements IEstadisticasServicio{
    
    private final Integer PAGE = 0;
    private final Integer SIZE = 20;
    
    @Autowired
    private IEstadisticasRepositorio repositorio;
    
    @Override
    public List<Estadisticas> obtenerEstadisticas(String terrario_id) {
        Pageable page = PageRequest.of(PAGE, SIZE);
        
        return repositorio.findByTerrariosID(terrario_id, page);
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
    public Estadisticas registraEstadistica(Estadisticas recoleccion, Terrarios terrario) {
        recoleccion.setTerrario_id(terrario.getId());
        return repositorio.insert(recoleccion);
    }
    
}
