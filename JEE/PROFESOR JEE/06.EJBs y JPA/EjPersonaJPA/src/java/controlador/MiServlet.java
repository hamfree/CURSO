/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.FachadaSBLocal;
import modelo.Persona;

/**
 *
 * @author curso
 */
@WebServlet(name = "MiServlet", urlPatterns = {"/MiServlet"})
public class MiServlet extends HttpServlet {

    @EJB
    private FachadaSBLocal fachadaBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");

        String accion = request.getParameter("accion");

        Persona usu = null;
        usu = new Persona(dni, nombre, apellido);
        java.util.List<Persona> lista = null;
        
        
        String resultado = null;
        // Invocal a la LN para añadir el registro
        switch (accion) {
            case "buscarPorId":
                usu = fachadaBean.buscarPersonaPorId(dni);
                resultado = "Encontrado: " + usu;
                break;
            case "buscarPorNombre":
                lista = fachadaBean.buscarPersonaPorNombre(nombre);
                resultado = "Encontrado: " ;
                break;
            case "crear":
                fachadaBean.agregarPersona(usu);
                resultado = "Creado: " + usu;
                break;
            case "borrar":
                fachadaBean.borrarPersona(dni);
                resultado = "Borado: " + dni;
                break;
            case "actualizar":
                fachadaBean.actualizarPersona(usu);
                resultado = "Actualizado: " + usu;
                break;
            default:
                break;
        }
        request.setAttribute("atPersona", usu);
        request.setAttribute("atLista", lista);
        request.setAttribute("resultado", resultado);
        request.getRequestDispatcher("index.jsp").forward(request, response);

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
