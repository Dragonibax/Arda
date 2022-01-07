/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Terrarios;
import com.escom.ipn.Arda.Modelos.Usuarios;
import java.util.List;

/**
 *
 * @author DEZKS
 */
public interface ITerrariosServicio {
    public Terrarios registrarTerrario(Terrarios nuevo, Usuarios propietario);
    public Boolean terrarioExistente(Terrarios nuevo);
    public List<Terrarios> terrariosDeUsuarios(String id);
    public Boolean tieneTerrarios(String id);
    public Terrarios actualizarTerrario(Terrarios actualizado);
}
