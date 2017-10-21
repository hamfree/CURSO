/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controllers;

import com.acme.model.ColeccionDVD;
import com.acme.model.Dvd;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "DVDController", urlPatterns = {"/do"})
public class DVDController extends HttpServlet {

    private static final long serialVersionUID = 2462105600288999946L;

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
        ArrayList<Dvd> alDvd;
        ColeccionDVD listaDvd;
        String accion = request.getParameter("accion");
        HttpSession ses = request.getSession(true);
       
        if (ses.getAttribute("coleccion") == null){
            alDvd = new ArrayList<>();
            listaDvd = new ColeccionDVD(alDvd);
            
            ses.setAttribute("coleccion", listaDvd);
        } else {
            listaDvd = (ColeccionDVD) ses.getAttribute("coleccion");
        }
        
        //Debug:
        System.out.println("Acción recibida :" + accion);
        System.out.println("Coleccion :" + listaDvd.toString());
        

        
        switch (accion) {
            case "irAgregar":
                request.getRequestDispatcher("agregar.jsp").forward(request, response);
                break;
            case "irListar":
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                break;
            case "agregar":
                // Aquí realizamos la inclusión del DVD en la coleccion de DVD.....
                String titulo = request.getParameter("titulo");
                String director = request.getParameter("director");
                if (titulo.length() > 0 && director.length() > 0) {
                    Dvd d = new Dvd();
                    d.setDirector(director);
                    d.setTitulo(titulo);
                    listaDvd.agregarDVD(d);
                } else {
                    System.out.println("Uno o varios de los parámetros del nuevo DVD es nulo... ");
                }
                
                // Una vez añadido mostramos el listado de DVDs que incluirá el nuevo DVD
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("index.html").forward(request, response);
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
