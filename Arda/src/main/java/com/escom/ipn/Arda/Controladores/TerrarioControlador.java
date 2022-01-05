/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Controladores;

import com.escom.ipn.Arda.Modelos.JsonResponse;
import com.escom.ipn.Arda.Modelos.Terrarios;
import com.escom.ipn.Arda.Servicios.IFirmasServicio;
import com.escom.ipn.Arda.Servicios.ITerrariosServicio;
import com.escom.ipn.Arda.Servicios.ITokensServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEZKS
 */
@RestController
@RequestMapping("/api/private")
public class TerrarioControlador {

    @Autowired
    private ITerrariosServicio servicioTerrarios;

    @Autowired
    private ITokensServicio servicioTokens;

    @Autowired
    private IFirmasServicio servicioFirmas;

    @PostMapping("/terrarios")
    public ResponseEntity<JsonResponse> postTerrario(@RequestBody Terrarios terrario, @RequestHeader("Authorization") String token) {
        if (servicioTerrarios.terrarioExistente(terrario)) {
            return new ResponseEntity(new JsonResponse("Este Terrario ya fue registrado"), HttpStatus.CONFLICT);
        } else {
            Terrarios resultado = servicioTerrarios.registrarTerrario(terrario, servicioTokens.getUserFromToken(token));
            String firma = servicioTokens.crearTokenTerrario(resultado);
            servicioFirmas.guardarFirma(resultado.getId(), firma);
            return new ResponseEntity(new JsonResponse(resultado, "El terrario se dio de alta con exito"), HttpStatus.CREATED);
        }
    }

    @GetMapping("/terrarios")
    public void getTerrarios(@RequestHeader("Authorization") String token) {

    }

    @GetMapping("/terrarios/{User_ID}/{Terrario_ID}")
    public void getTerrario() {

    }

    @DeleteMapping("/terrarios")
    public void deleteTerrario() {

    }

    @PatchMapping("/terrarios")
    public void patchTerrario() {

    }
}
