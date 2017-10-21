package com.acme;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author curso
 */
@WebServlet(name = "ProcesaServlet", urlPatterns = {"/usuario","/anuncio"})
public class ProcesaServlet extends HttpServlet {

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getServletPath();

        // Para depuracion sacaremos por la consola del servidor la ruta del servlet
        System.out.println("ServletPath=" + accion);
        
        if (accion.equalsIgnoreCase("/usuario")) {
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Introduzca su anuncio</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1 style='text-align: center'>Introduzca los datos de su anuncio, " + usuario + "</h1>");
                out.println("<h2 style='text-align: center'>Su contraseña es: '" + clave + "'.</h2>");
                out.println("<form style='text-align: center' action='anuncio' method='post'>");
                out.println("<p>Tema: <input type='text' name='tema' value='' /></p>");
                out.println("<p>Texto: <input type='text' name='texto' value='' /></p>");
                out.println("<p><input type='submit' value='Enviar' /></p>");
                out.println("</form");
                out.println("</body>");
                out.println("</html>");
            }
        } else if (accion.equalsIgnoreCase("/anuncio")) {
            String tema = request.getParameter("tema");
            String texto = request.getParameter("texto");
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Gracias</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1 style='text-align: center'>Gracias</h1>");
                out.println("<p style='text-align: center'>");
                out.println("Vendo :" + tema + "<br>");
                out.println("Descripcion:" + texto);
                out.println("</p>");
                out.println("</body>");
                out.println("</html>");
            }
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
