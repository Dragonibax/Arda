/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Lagartijas;
import com.escom.ipn.Arda.Repositorios.ILagartijasRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEZKS
 */
@Service
public class LagartijasServicioImpl implements ILagartijasServicio{
    
    @Autowired
    private ILagartijasRepositorio repositorio;
    
    @Override
    public Lagartijas guardarLagartija(Lagartijas iguana) {
        return repositorio.insert(iguana);
    }

    @Override
    public Lagartijas actualizarDatos(Lagartijas iguana) {
        return repositorio.save(iguana);
    }

    @Override
    public Lagartijas buscar(String iguanaID) {
        Optional<Lagartijas> result = repositorio.findById(iguanaID);
        if(result.isPresent()){
            return result.get();
        }else{
            throw new Error("NOHAYLAGARTIJA");
        }
    }

    @Override
    public List<Lagartijas> buscarporterrario(String TerrarioID) {
        return repositorio.findByTerrario_Id(TerrarioID);
    }

    @Override
    public Boolean existeEnElTerrario(Lagartijas lagartija) {
        System.out.print(repositorio.findByNombreAndTerrario_id(lagartija.getNombre(), lagartija.getTerrario_id()));
        return repositorio.findByNombreAndTerrario_id(lagartija.getNombre(), lagartija.getTerrario_id())!=null;
    }
    
}
