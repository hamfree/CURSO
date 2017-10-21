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
public class MiEscuchante implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("---->iniciado contexto");
        ServletContext ctx = sce.getServletContext();
        ctx.setAttribute("atctx", new Date());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         System.out.println("---->destruido contexto");
        
    }
}
