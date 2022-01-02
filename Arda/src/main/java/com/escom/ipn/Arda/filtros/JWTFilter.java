/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.filtros;

import com.escom.ipn.Arda.Modelos.Usuarios;
import com.escom.ipn.Arda.Servicios.ITokensServicio;
import com.escom.ipn.Arda.Servicios.TokensServicioImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author DEZKS
 */
public class JWTFilter extends OncePerRequestFilter {

    private final String HEADER = "Authorization";
    private final String CLAIM = "User";
    
    private final String PREFIX = "Bearer ";
    
    @Autowired
    private final ITokensServicio serviciotokens = new TokensServicioImpl();
    

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (existeJWTToken(request, response)) {
                String token = this.getToken(request);
                Claims claims = serviciotokens.validaToken(token);
                if (claims.get(CLAIM) != null) {
                    Autorizar(claims);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            System.out.print(e.getMessage());
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
    }

    private String getToken(HttpServletRequest request){
        return request.getHeader(HEADER);
    }

    /**
     * Metodo para autenticarnos dentro del flujo de Spring
     *
     * @param claims
     */
    private void Autorizar(Claims claims) {
        Usuarios User = claims.get(CLAIM, Usuarios.class);
        System.out.print(User.getNombre());
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(User.getNombre(),User.getContraseña());
        SecurityContextHolder.getContext().setAuthentication(auth);

    }

    private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse res) {
        String authenticationHeader = request.getHeader(HEADER);
        if (authenticationHeader == null) {
            return false;
        }
        return true;
    }
}
