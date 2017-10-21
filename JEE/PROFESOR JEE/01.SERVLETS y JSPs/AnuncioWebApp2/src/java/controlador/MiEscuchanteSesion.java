/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author curso
 */
@WebListener
public class MiEscuchanteSesion implements  HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("--->Creada sesion");
       
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("--->Destruida sesion");
    }
}
