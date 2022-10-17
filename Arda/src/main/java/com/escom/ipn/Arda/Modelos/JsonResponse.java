/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.Arda.Modelos;

/**
 *
 * @author DEZKS
 */
public class JsonResponse {
    private String Error;
    private Object body;
    private String Mensaje;

    public JsonResponse(String Error) {
        this.Error = Error;
    }

    public JsonResponse(Object body, String Mensaje) {
        this.body = body;
        this.Mensaje = Mensaje;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
    
    
}
