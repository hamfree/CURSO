/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Date;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author curso
 */
@WebListener
public class MiEscuchadorDeSesion implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession ses = se.getSession();
        System.out.println("Sesión " + ses.getId() + " creada en  " + new Date(ses.getCreationTime()) );
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession ses = se.getSession();
        System.out.println("Sesión " + ses.getId() + " destruida en  " + new Date(System.currentTimeMillis()) );
    }
}
