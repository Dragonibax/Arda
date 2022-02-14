/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Controladores.Publicos;

import com.escom.ipn.Arda.Modelos.Firmas;
import com.escom.ipn.Arda.Modelos.Usuarios;
import com.escom.ipn.Arda.Modelos.JsonResponse;
import com.escom.ipn.Arda.Modelos.Terrarios;
import com.escom.ipn.Arda.Servicios.IFirmasServicio;
import com.escom.ipn.Arda.Servicios.ITerrariosServicio;
import com.escom.ipn.Arda.Servicios.ITokensServicio;
import com.escom.ipn.Arda.Servicios.IUsuariosServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEZKS
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
@RequestMapping("/api/public")
public class AutorizacionControlador {

    @Autowired
    IUsuariosServicio servicioUsuarios;

    @Autowired
    ITokensServicio servicioTokens;

    @Autowired
    ITerrariosServicio servicioTerrarios;

    @Autowired
    IFirmasServicio servicioFirmas;
    
    @Operation(summary = "Inicio de Sesión", description = "Se puede hacer un inicio de sesión desde la web, se obtendra un Token de Autenticacion que debera ser guardado para su uso posterior")
    @ApiResponse(responseCode = "202", description = "Inicio de Sesion exitoso" )
    @ApiResponse(responseCode = "404", description = "El correo que se esta ingresando no esta registrado en nuestra base de datos")
    @ApiResponse(responseCode = "403" ,description = "La Contraseña introducida es incorrecta")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Objeto Requerido para comunicacion, los unicos campos obligatorios son 'Correo' y 'Contraseña' para el inicio de de sesion, los demas campos deberan estar vacios en medida de lo posible")
    @PostMapping("/iniciarsesion")
    public ResponseEntity<JsonResponse> Login(@RequestBody Usuarios User) {
        if (servicioUsuarios.existe(User.getCorreo())) {
            if (servicioUsuarios.verificaContraseña(User)) {
                String token = servicioTokens.crearTokenUsuario(servicioUsuarios.obtenerDatos(User.getCorreo()));
                return new ResponseEntity(new JsonResponse(token, "Inicio Exitoso"), HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity(new JsonResponse("La contraseña es incorrecta"), HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity(new JsonResponse("El correo no existe"), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/registrar")
    public ResponseEntity Registrar(@RequestBody Usuarios User) {
        if (servicioUsuarios.existe(User.getCorreo())) {
            return new ResponseEntity(new JsonResponse("Correo ya existente"), HttpStatus.CONFLICT);
        } else {
            servicioUsuarios.crearUsuario(User);
            return new ResponseEntity("¡Exito!", HttpStatus.CREATED);
        }
    }
    
    @Operation(summary = "Registro de Terrario", description = "Se da de alta un terrario en nuestro sistema")
    @ApiResponse(responseCode = "202", description = "El terrario se dio de alta con Exito" )
    @ApiResponse(responseCode = "409", description = "La firma del terrario ya fue reclamada, pongase en contacto con el administrador")
    @ApiResponse(responseCode = "401" ,description = "El terrario aun no se ha registrado desde la web")
    @Parameter(description = "Cabecera Utilizada para identificar el terrario, debe ser la direccion mac", name = "mac", example = "192.168.203.30")
    @GetMapping("/firmarterrario")
    public ResponseEntity<JsonResponse> firmarTerrario(@RequestHeader("mac") String mac) {
        Terrarios buscar = new Terrarios();
        buscar.setMac(mac);
        if (servicioTerrarios.terrarioExistente(buscar)) {
            buscar = servicioTerrarios.obtenerTerrarioporMac(mac);
            if (!servicioFirmas.firmaReclamada(buscar.getId())) {
                Firmas firma = servicioFirmas.obtenerFirma(buscar.getId());
                firma.setReclamada(Boolean.TRUE);
                servicioFirmas.cambiarEstatusFirma(firma);
                return new ResponseEntity(new JsonResponse(firma.getFirma(), "Firma de la placa"), HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity(new JsonResponse("La firma ya fue reclamada"), HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity(new JsonResponse("El terrario no esta registrado"), HttpStatus.UNAUTHORIZED);
        }
    }
}
