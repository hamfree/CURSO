/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author curso
 */
@WebServlet(name = "/ContadorDigitosServlet", urlPatterns = {"/dameDigito"})
public class ContadorDigitosServlet extends HttpServlet {

    static int contador = 0;

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
        if (request.getMethod().equalsIgnoreCase("POST")) {
            if (contador == 0) {
                response.setContentType("text/html;charset=UTF-8");

                try (PrintWriter out = response.getWriter()) {
                    out.println("<html><head><title>¡Acertaste!</title></head>");
                    out.println("<body style='text-align:center'><h1>¡Acertaste!</h1>");
                    out.println("<p><b><a href='index.html'>[ Volver al inicio ]</a></b></p>");
                    out.println("</body></html>");
                }
            } else {
                request.getRequestDispatcher("index.html").forward(request, response);
            }
        } else {
            response.setContentType("text/text;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                contador++;
                if (contador > 9) {
                    contador = 0;
                }
                out.println(contador);
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
