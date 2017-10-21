/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author curso
 */
public class MiEscuchador implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Se ejecuta una vez desplegada la aplicación
        
        ServletContext ctx = sce.getServletContext();
        System.out.println("-----> iniciado el contexto de " + ctx.getServletContextName());
        ctx.setAttribute("atctx", new Date());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Se ejecuta justo antes de destruir la aplicación
        ServletContext ctx = sce.getServletContext();
        System.out.println("-----> destruido el contexto de " + ctx.getServletContextName());
    }
}
