/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Repositorios;

import com.escom.ipn.Arda.Modelos.Estadisticas;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEZKS
 */
@Service
public interface IEstadisticasRepositorio extends MongoRepository<Estadisticas,String>{
    
    @Query("{ 'TerrariosID' : ?0 }")
    public List<Estadisticas> findByTerrariosID(String TerrariosID);

    @Override
    public <S extends Estadisticas> S insert(S entity);

    @Override
    public <S extends Estadisticas> List<S> insert(Iterable<S> entities);

    @Override
    public Optional<Estadisticas> findById(String id);
    
}
