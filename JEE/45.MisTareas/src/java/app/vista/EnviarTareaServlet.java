/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.vista;

import app.modelo.Delegado;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "EnviarTareaServlet", urlPatterns = {"/enviar"})
public class EnviarTareaServlet extends HttpServlet {
    private static final long serialVersionUID = 7211327272804165285L;

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
        String accion = request.getParameter("accion");
        HttpSession ses = request.getSession();
        String idSesion = ses.getId();
        Delegado dlg = Delegado.getInstance();
        switch (accion){
            
            case "agregar":
                String tarea = request.getParameter("tarea");
                if (dlg.agregarTarea(tarea, idSesion)){
                    request.setAttribute("mensaje", "Se agregó la tarea '" + tarea + "'.");
                } else {
                    request.setAttribute("mensaje", "*NO* Se agregó la tarea '" + tarea + "'.");
                }
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "finalizar":
                List<String> tareas = dlg.devolverTareas(idSesion);
                request.setAttribute("tareas", tareas);
                
                // Si hay otro usuario tirando contra el EJB, después de esto cascará ....
                dlg.finalizar();
                ses.invalidate();
                request.getRequestDispatcher("fin.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        
        
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
