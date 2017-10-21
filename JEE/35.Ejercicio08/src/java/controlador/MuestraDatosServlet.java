/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author curso
 */
@WebServlet(name = "MuestraDatosServlet", urlPatterns = {"/muestraDatos"})
public class MuestraDatosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sesion = request.getSession(true);
        
        
        if (request.getParameter("nombre").equalsIgnoreCase("Freddy")){
            throw new ServletException("Me peto, no me gusta ese nombre....");
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("<h2>Atributos de la sesión</h2>");
        Enumeration<String> e3 = sesion.getAttributeNames();
        while (e3.hasMoreElements()) {
            String nomAtrbSes = e3.nextElement();
            sb.append(nomAtrbSes).append(" = '").append(sesion.getAttribute(nomAtrbSes)).append("'<br>");
        }
        
        sb.append("<h2>Atributos de la petición</h2>");
        Enumeration<String> e = request.getAttributeNames();
        while (e.hasMoreElements()){
            String nombre = e.nextElement();
            if (nombre.length() > 0) {
                sb.append(nombre).append(" = '").append(request.getAttribute(nombre)).append("'<br>");
            }
        }
        sb.append("<h2>Parámetros de la petición</h2>");
        Enumeration<String> e2 = request.getParameterNames();
        while (e2.hasMoreElements()){
            String nombreParam = e2.nextElement();
            if (nombreParam.length() > 0){
                sb.append(nombreParam).append(" = '").append(request.getParameter(nombreParam)).append("'<br>");
            }
        }
        
        sb.append("<hr>");
        
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MuestraDatosServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet 'MuestraDatosServlet' en '" + request.getContextPath() + "'</h1>");
            out.println(sb.toString());
            out.println("<p><a href='index.html'>Volver al inicio</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
