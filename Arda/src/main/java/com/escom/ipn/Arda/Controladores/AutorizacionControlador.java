/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Controladores;

import com.escom.ipn.Arda.Modelos.Usuarios;
import com.escom.ipn.Arda.Modelos.Error;
import com.escom.ipn.Arda.Servicios.IUsuariosServicio;
import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEZKS
 */
@RestController
@RequestMapping("/api/public")
public class AutorizacionControlador {

    @Autowired
    IUsuariosServicio servicio;

    @PostMapping("/inicarsesion")
    public ResponseEntity Login(@RequestBody Usuarios User) {
        if(servicio.existe(User.getCorreo())){
            if (servicio.verificaContraseña(User)) {
            return new ResponseEntity("OK", HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new Error("La contraseña es incorrecta"),HttpStatus.FORBIDDEN);
        }
        }else{
            return new ResponseEntity(new Error("El correo no existe"),HttpStatus.BAD_REQUEST);
        }
        
    }

    @PostMapping("/registrar")
    public ResponseEntity Registrar(@RequestBody Usuarios User) {
        if (servicio.existe(User.getCorreo())) {
            return new ResponseEntity(new Error("Correo ya existente"), HttpStatus.CONFLICT);
        } else {
            servicio.crearUsuario(User);
            return new ResponseEntity("¡Exito!", HttpStatus.CREATED);
        }
    }

}
