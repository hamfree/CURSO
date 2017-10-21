package com.acme;

import java.io.IOException;
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
            
            LogicaNegocio ln = new LogicaNegocio();
            String nombre = ln.dameNombre(usuario, clave);
            
            if (nombre == null){
                nombre = "Desconocido";
            }
            request.setAttribute("nombre", nombre);
            request.getRequestDispatcher("formAnuncio.jsp").forward(request, response);
        } else if (accion.equalsIgnoreCase("/anuncio")) {
            String tema = request.getParameter("tema");
            request.setAttribute("tema", tema);
            String texto = request.getParameter("texto");
            request.setAttribute("texto", texto);
            
            request.getRequestDispatcher("verAnuncio.jsp").forward(request, response);
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
