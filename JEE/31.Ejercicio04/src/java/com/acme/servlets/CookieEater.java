/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author curso
 */
@WebServlet(name = "CookieEater", urlPatterns = {"/gestionaCookies"})
public class CookieEater extends HttpServlet {

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

        Cookie cookiesRecibidas[] = request.getCookies();

        //Debug
        System.out.println("Cantidad de cookies recibidas:" + cookiesRecibidas.length);
        //Fin debug

        int alea1 = (int) (Math.random() * 1000);
        int alea2 = (int) (Math.random() * 500);
        int alea3 = (int) (Math.random() * 60 * 60 * 24);

        Cookie galleta = new Cookie("galletita" + String.valueOf(alea2), String.valueOf(alea1));

        galleta.setMaxAge(alea3);
        response.addCookie(galleta);

        //Debug
        StringBuilder dbg = new StringBuilder();
        dbg.append("Nombre=").
                append(galleta.getName()).
                append(", Valor=").
                append(galleta.getValue()).
                append(", Caduca en ").
                append(galleta.getMaxAge());
        System.out.println(dbg.toString());
        //Fin debug

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookieEater</title>");
            out.println("</head>");
            out.println("<body style='text-align:center'>");
            out.println("<h1>Servlet CookieEater en " + request.getContextPath() + "</h1>");

            out.println("<h2>Galleta generada que se envía al navegador</h2>");
            out.println("<p>");
            out.print("Nombre: " + galleta.getName());
            out.print(", Valor: " + galleta.getValue());
            out.print(", Caduca en :" + galleta.getMaxAge() + " segundos.");
            out.println("</p>");
            out.println("<h2>Cookies recibidas del navegador</h2>");
            
            
            if (cookiesRecibidas.length > 0) {
                for (Cookie c : cookiesRecibidas) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("<p><strong>").append("Nombre=").
                            append(c.getName()).
                            append(",Valor").
                            append(c.getValue()).
                            append(", caduca en ").
                            append(c.getMaxAge()).
                            append(" dias.</strong></p>");

                    out.println(sb.toString());
                }
            }

            out.println("<p>");
            out.println("<a href='index.jsp'>Volver al inicio</a>");
            out.println("</p");

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
