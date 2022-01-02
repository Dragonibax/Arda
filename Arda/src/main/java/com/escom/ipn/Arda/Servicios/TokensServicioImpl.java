/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Usuarios;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEZKS
 */
@Service
public class TokensServicioImpl implements ITokensServicio {
    
    private final String SECRETO = "KappaIsLoveForSigmaAndNothingCanChangheThat";
    private final String USER = "User";
    private final String PREFIX = "Bearer ";
    private final JwtBuilder TOKENBUILDER = Jwts.builder();
    private final JwtParserBuilder PARSERBUILDER = Jwts.parserBuilder();
    private final SignatureAlgorithm FIRMA = SignatureAlgorithm.HS256;
    private SecretKey key;

    

    @Override
    public void getUserToken() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String crearToken(Usuarios User) {
        User.setContraseña("");
        key = Keys.hmacShaKeyFor(SECRETO.getBytes());
        String token = TOKENBUILDER.setSubject(User.getNombre())
                .claim(USER, User)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+86400000))
                .signWith(key, FIRMA).compact();
        System.out.print(token);
        return PREFIX + token;
    }

    @Override
    public Claims validaToken(String JWT) {
        String token = JWT.replace(PREFIX, "");
        key = Keys.hmacShaKeyFor(SECRETO.getBytes());
        Jws<Claims> tokenparseado = PARSERBUILDER.setSigningKey(key).build().parseClaimsJws(token);
        System.out.print(tokenparseado.getBody().get(USER, Usuarios.class).getNombre());
        return tokenparseado.getBody();
    }
    
}
