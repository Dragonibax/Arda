/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Repositorios;

import com.escom.ipn.Arda.Modelos.Terrarios;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author DEZKS
 */
public interface ITerrariosRepositorio extends MongoRepository<Terrarios, String>{

    @Override
    public <S extends Terrarios> S insert(S entity);

    @Override
    public <S extends Terrarios> S save(S entity);

    public Terrarios findByMac(String Mac);
    
    @Query("{'usuarios_id':?0}")
    public List<Terrarios> findByUsuarios_id(String id);
    
}
