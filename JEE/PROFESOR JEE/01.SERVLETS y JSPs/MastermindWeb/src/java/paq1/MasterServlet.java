/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "MasterServlet", urlPatterns = {"/iniciar", "/seguir"})
public class MasterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getServletPath();
        if (accion.equals("/iniciar")) {
            Mastermind m = new Mastermind();
            m.iniciarJuego();
            HttpSession ses = request.getSession();
            ses.setAttribute("atmaster", m);
            request.getRequestDispatcher("intento.jsp").forward(request, response);
        } else if (accion.equals("/seguir")) {
            String can = request.getParameter("candidato");
            HttpSession ses = request.getSession(false);
            if (ses == null) {
                response.sendRedirect("index.html");
            } else {
                Mastermind m = (Mastermind) ses.getAttribute("atmaster");
                String r = m.adivinar(can);
                System.out.println("r es " + r);
                String destino;
                if (r.contains("ACERTASTE")) {
                    
                    destino = "fin.jsp";
                } else {
                    destino = "intento.jsp";
                }
                request.getRequestDispatcher(destino).forward(request, response);
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
