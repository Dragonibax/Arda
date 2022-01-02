/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios.Seguridad;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEZKS
 */
@Service
public class EncriptacionServicioImpl implements IEncriptacionServicio {
    
    MessageDigest cifrador = null;
    
    @Override
    public String Encriptar(String pwd) {
        try {
            cifrador = MessageDigest.getInstance("SHA-256");
            cifrador.update(pwd.getBytes());
            byte[] pwdb = cifrador.digest();
            char[] pwdc = Hex.encode(pwdb);
            return String.valueOf(pwdc);
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
        
    }
    
}
