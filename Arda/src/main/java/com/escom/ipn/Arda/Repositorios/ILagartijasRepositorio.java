/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Repositorios;

import com.escom.ipn.Arda.Modelos.Lagartijas;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author OnixR
 */
public interface ILagartijasRepositorio extends MongoRepository<Lagartijas, String>{

    @Override
    public <S extends Lagartijas> S insert(S entity);

    @Override
    public <S extends Lagartijas> S save(S entity);
    
    @Query("{'terrario_id':?0}")
    public List<Lagartijas> findByTerrario_Id(String ID);

    @Override
    public Optional<Lagartijas> findById(String id);
    
    @Query("{'nombre':?0,'terrario_id':?1}")
    public Lagartijas findByNombreAndTerrario_id(String Nombre, String terrario_id);
   
}
