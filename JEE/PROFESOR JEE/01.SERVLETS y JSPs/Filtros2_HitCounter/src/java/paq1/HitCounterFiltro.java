/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesus
 */
public class HitCounterFiltro implements Filter {

    private FilterConfig filterConfig;


    @Override
    public void init(FilterConfig config)
            throws ServletException {
        this.filterConfig = config;
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        System.out.println("Invocado doFilter de HitCounterFilter");

        if (filterConfig == null) {
            return;
        }

        // si no está definido el atributo todavía (primera vez) se establece         
        Counter counter = (Counter) filterConfig.getServletContext().getAttribute("hitCounter");
        if (counter == null) {
            counter = new Counter();
            filterConfig.getServletContext().setAttribute("hitCounter", counter);
        }

        String sw = "\n";
        sw += ("=======================================================");
        sw += ("Numero de hits: " + counter.incCounter());
        sw += ("=======================================================");

        // Log la cadena resultante
        filterConfig.getServletContext().log(sw);

        PrintWriter out = response.getWriter();
        RespuestaWrapper wrapper = new RespuestaWrapper((HttpServletResponse) response);
        chain.doFilter(request, wrapper);
        System.out.println("A la vuelta de doFilter(). En wrapper se tiene: " + wrapper);
        // Justo antes de la terminacion de </body> pone el contador
        String caw = wrapper.toString().substring(0, wrapper.toString().indexOf("</body>") - 1);
        //CharArrayWriter caw = new CharArrayWriter();
        caw += "<p>\nVisitante numero: <font color=\"red\">" + counter.getCounter() + "</font>";
        caw += "\n</body></html>";
        //response.setContentLength(caw.toString().length());
        out.write(caw);

        out.close();
    }

    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("OrderFilter()");
        }
        StringBuffer sb = new StringBuffer("OrderFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
}

