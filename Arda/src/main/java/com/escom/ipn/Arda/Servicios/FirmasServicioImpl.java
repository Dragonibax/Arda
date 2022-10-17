/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Firmas;
import com.escom.ipn.Arda.Repositorios.IFirmasRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEZKS
 */
@Service
public class FirmasServicioImpl implements IFirmasServicio{
    
    @Autowired
    private IFirmasRespositorio repositorio;

    @Override
    public Firmas guardarFirma(String terrario_id, String token) {
        Firmas firma = new Firmas(token, Boolean.FALSE, terrario_id);
        return repositorio.insert(firma);
    }

    @Override
    public Boolean firmaReclamada(String terrario_id) {
        Firmas firma = repositorio.findByTerrario_id(terrario_id);
        return firma.getReclamada();
    }

    @Override
    public Firmas obtenerFirma(String terrario_id) {
        return repositorio.findByTerrario_id(terrario_id);
    }

    @Override
    public void cambiarEstatusFirma(Firmas firma) {
        repositorio.save(firma);
    }

    
    
}
