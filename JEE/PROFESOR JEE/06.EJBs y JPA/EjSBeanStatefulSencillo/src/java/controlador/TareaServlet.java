/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.FachadaBeanTareaLocal;

/**
 *
 * @author oracle
 */
@WebServlet(name = "TareaServlet", urlPatterns = {"/anadir","/finalizar"})
public class TareaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FachadaBeanTareaLocal servicio = null;
        String destino = null;
        String accion = request.getServletPath();

        if (accion.equals("/anadir")) {
           String tarea = request.getParameter("tarea");

            HttpSession session = request.getSession();
            servicio = (FachadaBeanTareaLocal) session.getAttribute("servicio");

            if (servicio == null) {
                servicio = lookupFachadaBeanLocal();
                System.out.println("---->Consigo SB primero " + servicio);
                session.setAttribute("servicio", servicio);
            }

            System.out.println("---->servicio en anadir: " + servicio);
            servicio.anotarTarea( tarea);

            destino = "/index.jsp";
        } else if (accion.equals("/finalizar")) {
            HttpSession session = request.getSession();
            servicio = (FachadaBeanTareaLocal) session.getAttribute("servicio");

           List<String> lista = servicio.getTrabajoDiario().getTareas();
            request.setAttribute("atlista", lista);
             servicio.acabar();
            session.invalidate();
            destino = "/gracias.jsp";
        }
        getServletContext().getRequestDispatcher(destino).forward(request, response);

    }

    private FachadaBeanTareaLocal lookupFachadaBeanLocal() {
        FachadaBeanTareaLocal retorno = null;
        try {
            Context c = new InitialContext();
            retorno = (FachadaBeanTareaLocal) c.lookup("java:app/EjSBeanStatefulSencillo/FachadaBeanTarea");
        } catch (NamingException ne) {
            System.out.println("Horrrror en lookup" + ne);
        }
        return retorno;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
