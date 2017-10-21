/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Usuario;
import modelo.Anuncio;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Anuncio;
import modelo.FachadaBeanLocal;

/**
 *
 * @author Infomática
 */
public class ControladorServlet extends HttpServlet {

    @EJB
    private FachadaBeanLocal fachadaBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dedondevengo = request.getServletPath();
        if (dedondevengo.equals("/hola")) {
            String s1 = request.getParameter("user");
            String s2 = request.getParameter("pass");
            // se delega en LN para consulta en BD.
            Usuario usuario = fachadaBean.dameUsuario(s1, s2);
            System.out.println("Usuario:"+usuario);
            if (usuario == null) {
                request.setAttribute("mensaje", "Usuario o password erroneo");
                getServletContext().getRequestDispatcher("/index.jsp").
                        forward(request, response);
            } else {
                HttpSession ses = request.getSession(true);
                ses.setAttribute("atusuario", usuario);

                getServletContext().getRequestDispatcher("/anuncio.jsp").
                        forward(request, response);
            }
        } else if (dedondevengo.equals("/anuncio")) {
            String s3 = request.getParameter("tema");
            String s4 = request.getParameter("msg");
            Anuncio anun = new Anuncio(s3, s4);
            request.setAttribute("atanuncio", anun);

            HttpSession ses = request.getSession(false);
            String usu = ((Usuario) ses.getAttribute("atusuario")).getIdUser();

            fachadaBean.insertarAnuncio(usu, anun);
            request.getRequestDispatcher("ultimo.jsp").forward(request, response);

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
