/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.security.DeclareRoles;
import javax.ejb.AccessLocalException;
import javax.ejb.EJB;
import javax.ejb.EJBAccessException;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MiServlet", urlPatterns = {"/MiServlet"})
@DeclareRoles({"jefe", "currito"})
@ServletSecurity(
        @HttpConstraint(rolesAllowed = {"jefe", "currito"}))
public class MiServlet extends HttpServlet {

    @EJB
    private HolaMundoSBLocal holaMundoSB;
    private static final long serialVersionUID = -500180835667312943L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombreUsuario = request.getUserPrincipal().getName();
        boolean esJefe = request.isUserInRole("jefe");
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MiServlet</title>");
            out.println("</head>");
            out.println("<body style='text-align:center;font-family: monotype'>");
            out.println("<h1>Hola, usuario '" + nombreUsuario + "'</h1>");
            if (esJefe) {
                out.println("<h2>Eres un jodido jefe</h2>");
            } else {
                out.println("<h2>Eres un pringado empleado</h2>");
            }
            out.println("<p>Llamando al metodo EJB saludar():</p>");
            try {
                out.println(holaMundoSB.saludar(nombreUsuario));
            } catch (EJBAccessException ale) {
                out.println("<p style='color:red'>Error de seguridad: no tiene acceso al metodo EJB saludar()</p>");
            }
            out.println("<p>Llamando al metodo EJB dameInfo():</p>");
            out.println("<p>" + holaMundoSB.dameDatosUsuario() + "&nbsp;</p>");
            out.println("<p>Esto debería salir...</p>");
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
