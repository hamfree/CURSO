
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ColeccionDVDs;
import modelo.DVD;

/**
 *
 * @author student
 */
@WebServlet(name = "DVDServlet", urlPatterns = {"/DVDServlet"})
public class DVDServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        if (sesion.getAttribute("atlista") == null) {
            ColeccionDVDs col = new ColeccionDVDs();
            sesion.setAttribute("atlista", col);
        }

        String accion = request.getParameter("accion");
        System.out.println("accion="+accion);
        if (accion.equals("listar")) {
            System.out.println(response.encodeURL("kjhlkjh"));
            request.getRequestDispatcher("coleccion.jsp").forward(request, response);
        } else if (accion.equals("nuevo")) {
            request.getRequestDispatcher("nuevodvd.jsp").forward(request, response);
        } else if (accion.equals("insertar")) {
            ColeccionDVDs lista = (ColeccionDVDs)sesion.getAttribute("atlista");
            DVD d = new DVD(request.getParameter("director"),
                             request.getParameter("titulo"));
            lista.agregarDVD(d);
            request.getRequestDispatcher("coleccion.jsp").forward(request, response);
        }





    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
