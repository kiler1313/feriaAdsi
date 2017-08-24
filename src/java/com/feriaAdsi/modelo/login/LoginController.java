/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feriaAdsi.modelo.login;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author cheswill
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    
    private String correo;
    private String contrasena;
    private String urlDestino;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    @PostConstruct
    public void init(){
    }
    
    
    public LoginController() {
    }
    
    
    public String iniciarSesion(){
            if(getCorreo().contains("admin@gmail.com") && getContrasena().contains("123456")){
                urlDestino = "tablaPartidos.xhtml?faces-redirect=true";
            } else{
                urlDestino = "index.xhtml?faces-redirect=true";
            }
        
        return urlDestino;
    }
}
