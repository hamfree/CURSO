package com.acme;

import modelo.Anuncio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.GestorAnuncios;
import modelo.Usuario;

@WebServlet(name = "AnuncioServlet", urlPatterns = {"/usuario", "/anuncio"})
public class AnuncioServlet extends HttpServlet {

    private static final long serialVersionUID = 8525210272641920355L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getServletPath();
        System.out.println("-->" + accion);

        

        switch (accion) {
            case "/usuario":
                {
                    String u = request.getParameter("user");
                    String p = request.getParameter("pass");
                    // delegaria en LN para comproibacion de password y que me de los datos de user
                    GestorAnuncios gestor = new GestorAnuncios();
                    Usuario usu = gestor.dameUsuario(u, p);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("atusuario", usu);
                    request.getRequestDispatcher("anuncio.jsp").forward(request, response);
                    break;
                }
            case "/anuncio":
                {
                    String tem = request.getParameter("tema");
                    String txt = request.getParameter("texto");
                    // delegaria en LN para insertar en anuncio
                    Anuncio anuncio = new Anuncio();
                    anuncio.setTema(tem);
                    anuncio.setTexto(txt);
                    request.setAttribute("atanuncio", anuncio);
                    HttpSession session = request.getSession(false);
                    Usuario usu = (Usuario) session.getAttribute("atusuario");
                    request.setAttribute("atadiosusuario", usu);
                    session.invalidate();
                    request.getRequestDispatcher("fin.jsp").forward(request, response);
                    break;
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
        return "Controla el flujo de la información en el Portal de anuncios.";
    }// </editor-fold>

}
