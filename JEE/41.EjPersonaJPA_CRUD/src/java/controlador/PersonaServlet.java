/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
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
@WebServlet(name = "PersonaServlet", urlPatterns = {"/gestPersona"})
public class PersonaServlet extends HttpServlet {

    private static final long serialVersionUID = 531110621469801084L;
    @EJB
    private FachadaSBLocal fachadaSB;

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

        String d = request.getParameter("dni");
        String n = request.getParameter("nombre");
        String a = request.getParameter("apellido");
        String acc = request.getParameter("accion");
        Persona p;

        System.out.println("DBG:" + d + "," + n + "," + a + "," + acc);
        switch (acc) {
            case "AGREGAR":
                fachadaSB.agregarPersona(new Persona(d, n, a));
                request.setAttribute("respuesta", "La persona fue añadida.");
                break;
            case "BUSCAR POR ID":
                p = fachadaSB.buscarPersona(d);
                if (p != null) {
                    request.setAttribute("dni", p.getDni());
                    request.setAttribute("nombre", p.getNombre());
                    request.setAttribute("apellido", p.getApellido());
                    request.setAttribute("respuesta", "La persona fue encontrada.");
                } else {
                    request.setAttribute("dni", d);
                    request.setAttribute("nombre", "");
                    request.setAttribute("apellido", "");
                    request.setAttribute("respuesta", "La persona *NO* fue encontrada.");
                }
                break;

            case "BUSCAR POR NOMBRE":
                Vector<Persona> lista = (Vector<Persona>) fachadaSB.buscarPorNombre(n);
                if (lista != null) {
                    if (lista.size() > 1) {
                        request.setAttribute("listaPersonas", lista);
                        request.getRequestDispatcher("listado.jsp").forward(request, response);
                    } else {
                        request.setAttribute("dni", lista.get(0).getDni());
                        request.setAttribute("nombre", lista.get(0).getNombre());
                        request.setAttribute("apellido", lista.get(0).getApellido());
                        request.setAttribute("respuesta", "La persona fue encontrada.");
                    }
                } else {
                    request.setAttribute("dni", "");
                    request.setAttribute("nombre", n);
                    request.setAttribute("apellido", "");
                    request.setAttribute("respuesta", "La persona *NO* fue encontrada.");
                }
                break;
            case "MODIFICAR":
                p = fachadaSB.modificarPersona(d, n, a);
                if (p != null) {
                    request.setAttribute("dni", d);
                    request.setAttribute("nombre", p.getNombre());
                    request.setAttribute("apellido", p.getApellido());
                    request.setAttribute("respuesta", "La persona fue modificada.");
                }
                break;
            case "BORRAR":
                fachadaSB.borrarPersona(d);
                break;
            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
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
