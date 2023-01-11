/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Servicios;

import com.escom.ipn.Arda.Modelos.Terrarios;
import com.escom.ipn.Arda.Modelos.Usuarios;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;
/**
 *
 * @author OnixR
 */
@Service
public class TokensServicioImpl implements ITokensServicio {
    
    private final String SECRETO = "KappaIsLoveForSigmaAndNothingCanChangheThat";
    private final String USER = "User";
    private final String TERRARIO = "Terrario";
    private final String PREFIX = "Bearer ";
    private final JwtBuilder TOKENBUILDER = Jwts.builder();
    private final JwtParserBuilder PARSERBUILDER = Jwts.parserBuilder();
    private final SignatureAlgorithm FIRMA = SignatureAlgorithm.HS256;
    private SecretKey key;

    
    @Override
    public String crearTokenUsuario(Usuarios User) {
        User.setContraseña("");
        key = Keys.hmacShaKeyFor(SECRETO.getBytes());
        String token = TOKENBUILDER.setSubject(User.getNombre())
                .claim(USER, User)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+86400000))
                .signWith(key, FIRMA).compact();
        return PREFIX + token;
    }

    @Override
    public Boolean validaToken(String JWT) {
        String token = JWT.replace(PREFIX, "");
        key = Keys.hmacShaKeyFor(SECRETO.getBytes());
        Jws<Claims> tokenparseado = PARSERBUILDER.setSigningKey(key).build().parseClaimsJws(token);
        return tokenparseado.getBody().get(USER)!=null||tokenparseado.getBody().get(TERRARIO)!=null;
    }

    @Override
    public Usuarios getUserFromToken(String JWT) {
        String token = JWT.replace(PREFIX, "");
        key = Keys.hmacShaKeyFor(SECRETO.getBytes());
        Jws<Claims> tokenparseado = PARSERBUILDER.setSigningKey(key).build().parseClaimsJws(token);
        Map<String, String> user = (Map<String, String>) tokenparseado.getBody().get(USER);
        return new Usuarios(user.get("id"), user.get("correo"), user.get("contraseña"), user.get("nombre"));
    }

    @Override
    public String crearTokenTerrario(Terrarios terrario) {
        key = Keys.hmacShaKeyFor(SECRETO.getBytes());
        String token = TOKENBUILDER.setSubject(terrario.getMac())
                .claim(TERRARIO, terrario).setExpiration(null)
                .signWith(key, FIRMA).compact();
        return PREFIX + token;
    }

    @Override
    public Terrarios getTerrarioFromToken(String JWT) {
        String token = JWT.replace(PREFIX, "");
        key = Keys.hmacShaKeyFor(SECRETO.getBytes());
        Jws<Claims> tokenparseado = PARSERBUILDER.setSigningKey(key).build().parseClaimsJws(token);
        Map<String,String> terrario = (Map<String,String>) tokenparseado.getBody().get(TERRARIO);
        return new Terrarios(terrario.get("id"),terrario.get("ubicacion"), terrario.get("altura"), terrario.get("iluminacion_tipo"), terrario.get("usuarios_id"));
    }
    
}
