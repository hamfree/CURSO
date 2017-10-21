/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesus
 */
@WebFilter(filterName = "MiFiltro", urlPatterns = {"/DVDServlet"})
public class MiFiltro implements Filter {
    
    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public MiFiltro() {
    }    
    

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
          HttpSession ses = ((HttpServletRequest)request).getSession();
          
        if (request.getParameter("user")!= null){
            // viene parametro con identificador
             ses.setAttribute("user", request.getParameter("user"));
             //((HttpServletResponse)response).sendRedirect("index.jsp");
             RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } else    if (ses.getAttribute("user") == null){
            // no viene parametro y no se identifico previamente
            // ((HttpServletResponse)response).sendRedirect("login.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } else{
             // no viene parametro y si se identifico previamente
            chain.doFilter(request, response);
        }
        
        

            
        
    
    }


    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }

}
