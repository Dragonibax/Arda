/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Repositorios;

import com.escom.ipn.Arda.Modelos.Usuarios;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEZKS
 */
@Service
public interface IUsuariosRepositorio extends MongoRepository<Usuarios, String>{
    
    public Usuarios findByCorreo(String Correo);

    @Override
    public <S extends Usuarios> S save(S entity);
    
}
