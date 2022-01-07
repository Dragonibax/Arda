/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Repositorios;

import com.escom.ipn.Arda.Modelos.Firmas;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author DEZKS
 */
public interface IFirmasRespositorio extends MongoRepository<Firmas, String>{

    @Override
    public <S extends Firmas> S insert(S entity);

    @Query("{'terrario_id':?0}")
    public Firmas findByTerrario_id(String id);

    @Override
    public <S extends Firmas> S save(S entity);
    
}
