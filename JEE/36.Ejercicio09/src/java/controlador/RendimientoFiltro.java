/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jesus
 */
public class RendimientoFiltro implements Filter {

    private FilterConfig config;
    private String logPrefix;

    @Override
    public void init(FilterConfig config)
            throws ServletException {
        this.config = config;
        logPrefix = config.getInitParameter("prefijo Log");
    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        System.out.println("FILTRO: " + config.getFilterName() + " doFilter()");
        long begin = System.currentTimeMillis();
        
        // Esto hace que salte al proximo elemento de la cadena de filtros, en este caso el servlet...
        chain.doFilter(request, response);
        
        System.out.println("FILTRO: " + config.getFilterName() + " : Volviendo de doFilter()");
        long end = System.currentTimeMillis();

        StringBuffer logMessage = new StringBuffer();
        if (request instanceof HttpServletRequest) {
            logMessage = ((HttpServletRequest) request).getRequestURL();
        }
        logMessage.append(": ");
        logMessage.append(end - begin);
        logMessage.append(" ms");

        if (logPrefix != null) {
            logMessage.insert(0, logPrefix);
        }

        // Incluimos el mensaje en el log del servidor para los servlets
        config.getServletContext().log(logMessage.toString());
    }

    @Override
    public void destroy() {
        config = null;
        logPrefix = null;
    }

}
